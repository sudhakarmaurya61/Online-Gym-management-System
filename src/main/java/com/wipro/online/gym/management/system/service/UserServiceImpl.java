package com.wipro.online.gym.management.system.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.online.gym.management.system.dto.ResponseDto;
import com.wipro.online.gym.management.system.dto.UserDTO;
import com.wipro.online.gym.management.system.model.ContactUs;
import com.wipro.online.gym.management.system.model.Feedback;
import com.wipro.online.gym.management.system.model.Package;
import com.wipro.online.gym.management.system.model.SlotBooking;
import com.wipro.online.gym.management.system.model.Trainner;
import com.wipro.online.gym.management.system.model.User;
import com.wipro.online.gym.management.system.repo.ContactUsRepository;
import com.wipro.online.gym.management.system.repo.FeedbackRepository;
import com.wipro.online.gym.management.system.repo.PackageRepository;
import com.wipro.online.gym.management.system.repo.SlotbookingRepository;
import com.wipro.online.gym.management.system.repo.TrainnerRepository;

import org.apache.commons.codec.binary.Base64;

@Service
public class UserServiceImpl implements IUserInterface{

	@Autowired
	UserRepository userRepository;
	@Autowired
	PackageRepository packageRepository;
	@Autowired
	SlotbookingRepository slotbookingRepository;
	@Autowired
	TrainnerRepository trainnerRepository;
	@Autowired
	FeedbackRepository feedbackRepository;
	@Autowired
	ContactUsRepository contactUsRepository;
	@Autowired
	EmailSender emailSender;
	
	@SuppressWarnings("unused")
	@Override
	public ResponseDto saveUserDetails(UserDTO userDTO) {
		ResponseDto responseDto=new ResponseDto();
		User user =new User();
		List<User> extingUser=userRepository.findByEmail(userDTO.getEmail());
		System.out.println("extingUser----"+extingUser);
		if(extingUser.isEmpty())
		{
		user.setAddress(userDTO.getAddress());
		user.setAge(userDTO.getAge());
		user.setContact(userDTO.getContact());
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		byte[] pswd=userDTO.getPassword().getBytes();
		user.setPassword(userDTO.getPassword());
		//user.setPassword(org.apache.commons.codec.binary.Base64.encodeBase64(userDTO.getPassword().getBytes()).toString());

		user.setRole("User");
		User userRepsone=userRepository.save(user);
		if(userRepsone.getId()!=0) {
		responseDto.setError(false);
		responseDto.setStatusCode(200);
		responseDto.setMessage("User register successfully.");
		responseDto.setObjectData(userRepsone);
		}
		else
		{
			responseDto.setError(false);
			responseDto.setStatusCode(200);
			responseDto.setMessage("Somthings went wrong!");
		}
		}
		else
		{
			responseDto.setError(false);
			responseDto.setStatusCode(200);
			responseDto.setMessage("User allready Register.");
		}
		
		return responseDto;
	}
	@Override
	public ResponseDto loginUser(UserDTO userDto) {
		ResponseDto responseDto=new ResponseDto();
		User user=userRepository.findByEmailAndPassword(userDto.getEmail(),userDto.getPassword());
		System.out.println(user);
		if(user.getEmail().equalsIgnoreCase(userDto.getEmail()))
		{
			responseDto.setError(false);
			responseDto.setStatusCode(200);
			responseDto.setMessage("User Login successfully");
			responseDto.setObjectData(user);
		}
		else
		{
			responseDto.setError(false);
			responseDto.setStatusCode(200);
			responseDto.setMessage("User not Registered.");
		}
		return responseDto;
	}
	@Override
	public ResponseDto findByUserId(UserDTO userDto) {
		ResponseDto responseDto=new ResponseDto();
		Optional<User> user=userRepository.findById(userDto.getId());
		System.out.println(user);
		if(!user.isEmpty())
		{
			responseDto.setError(false);
			responseDto.setStatusCode(200);
			responseDto.setMessage("User details get successfully");
			responseDto.setObjectData(user);
		//List<SlotBooking> slotDetails=slotbookingRepository.getSlotBookingByUserId(userDto.getId());
			List<SlotBooking> slotDetails=slotbookingRepository.getSlotBookingByUserIdAndStatus(userDto.getId(),1);
		responseDto.setBookingData(slotDetails);
		Trainner trainer=trainnerRepository.getTrainerById(slotDetails.get(0).getTrainerId());
		responseDto.setTrainer(trainer);
		}
		else
		{
			responseDto.setError(false);
			responseDto.setStatusCode(200);
			responseDto.setMessage("User not Registered.");
		}
		return responseDto;
	}
	@Override
	public ResponseDto resetUserPassword(UserDTO userDto) {
		ResponseDto responseDto=new ResponseDto();
		Optional<User> user=userRepository.findById(userDto.getId());
		System.out.println(user);
		if(user.isPresent())
		{ 
			User updatedUser= user.get();
			updatedUser.setEmail(userDto.getEmail());
			updatedUser.setPassword(userDto.getPassword());
			User userRepsone=userRepository.save(updatedUser);
			if(userRepsone.getId()!=0) {
			responseDto.setError(false);
			responseDto.setStatusCode(200);
			responseDto.setObjectData(userRepsone);
			responseDto.setMessage("User password updated successfully.");
			}
		}
		else
		{
			responseDto.setError(false);
			responseDto.setStatusCode(200);
			responseDto.setMessage("User not Registered.");
		}
		return responseDto;
	}
	@Override
	public ResponseDto getPackgeDetails() {
		ResponseDto responseDto=new ResponseDto();
		List<Package> packageInfo=	packageRepository.findAll();
		responseDto.setError(false);
		responseDto.setStatusCode(200);
		responseDto.setMessage("User details get successfully");
		responseDto.setObjectData(packageInfo);
		return responseDto;
	}
	@Override
	public ResponseDto savePackage(UserDTO userDto) {
		ResponseDto responseDto=new ResponseDto();
		SlotBooking slotData=new SlotBooking();
		List<SlotBooking> slotDetails=slotbookingRepository.getSlotBookingByUserIdAndStatus(userDto.getId(),1);
        if(slotDetails.isEmpty()) {
		slotData.setPackageId(userDto.getPackageId());
		slotData.setUserId(userDto.getId());
		slotData.setSlotTime(userDto.getSlotTime());
		slotData.setBookingDate(getCurrentDate());
		slotData.setTrainerId(userDto.getTrainerId());
		slotData.setStatus(1);
		SlotBooking slot=slotbookingRepository.save(slotData);
		if(slot.getId()!=0) {
			responseDto.setError(false);
			responseDto.setStatusCode(200);
			responseDto.setMessage("Slot booking successfully.");
			responseDto.setBookingData(slot);
			Optional<User> user=userRepository.findById(userDto.getId());
			String message="Dear "+user.get().getName()+ ",\n Your Gym Booking is confirm from Date :"+getCurrentDate()+" & Time :"+slot.getSlotTime() +" \n Regards, \n Admin Team \n mob- 1234567890";
			String mailMessage=emailSender.sendSimpleMail( "Slot Booking Confirm",user.get().getEmail(), message);
			System.out.println("mailMessage---"+mailMessage);
			}
			else
			{
				responseDto.setError(false);
				responseDto.setStatusCode(200);
				responseDto.setMessage("Somthings went wrong!");
			}
}
else
{
	responseDto.setError(false);
	responseDto.setStatusCode(200);
	responseDto.setMessage("User have booking allready from date "+slotDetails.get(0).getBookingDate());	
}
		return responseDto;
	}
	private String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate));
		return dtf.format(localDate);
	}
	@Override
	public ResponseDto findTrainnerDetails(Integer trainerId) {
		ResponseDto responseDto=new ResponseDto();
		Trainner trainer=trainnerRepository.getTrainerById(trainerId);
		responseDto.setError(false);
		responseDto.setStatusCode(200);
		responseDto.setMessage("Trainer details getting successfully.");
		responseDto.setTrainer(trainer);
		return responseDto;
	}
	@Override
	public ResponseDto addTrainner(Trainner trainner) {
		ResponseDto responseDto=new ResponseDto();
		Trainner trainer=trainnerRepository.save(trainner);
		if(trainer.getId()!=0) {
		responseDto.setError(false);
		responseDto.setStatusCode(200);
		responseDto.setMessage("Trainer added successfully.");
		responseDto.setTrainer(trainer);
		}
		else
		{
			responseDto.setError(false);
			responseDto.setStatusCode(200);
			responseDto.setMessage("Somthings went wrong!");
		}
		return responseDto;
	}
	@Override
	public ResponseDto deleteTrainner(Trainner trainner) {
		ResponseDto responseDto=new ResponseDto();
		trainnerRepository.deleteById(trainner.getId());
		responseDto.setError(false);
		responseDto.setStatusCode(200);
		responseDto.setMessage("Trainer delete successfully.");
		return responseDto;
	}
	@Override
	public List<ResponseDto> getDashboardData() {
		List<ResponseDto> responseList=new ArrayList<ResponseDto>();
		List<User> allUser=userRepository.findAll();
		for(User user:allUser) {
			
			ResponseDto	responseDto=new ResponseDto();
			System.out.println("user-----"+user.toString());
			List<SlotBooking> slotDetails=slotbookingRepository.getSlotBookingByUserIdAndStatus(user.getId(),1);
			//List<SlotBooking> slotDetails=slotbookingRepository.getSlotBookingByUserId(user.getId());
			responseDto.setBookingData(slotDetails);
			System.err.println("slotDetails----"+slotDetails.toString());
			if(!slotDetails.isEmpty()) {
			Trainner trainer=trainnerRepository.getTrainerById(slotDetails.get(0).getTrainerId());
			Package packageInfo=packageRepository.getPackageById(slotDetails.get(0).getPackageId());
			responseDto.setTrainer(trainer);
			responseDto.setPackageData(packageInfo);
			}
			responseDto.setObjectData(user);
			responseList.add(responseDto);
			System.err.println("responseDto----"+responseDto.toString());
		}
		
		return responseList;
	}
	@Override
	public ResponseDto saveUserFeedback(Feedback feedback) {
		ResponseDto responseDto=new ResponseDto();
		feedback.setDate(getCurrentDate());
		System.err.println("feedback---"+feedback.toString());
		Feedback feedResponse=	feedbackRepository.save(feedback);
		responseDto.setError(false);
		responseDto.setStatusCode(200);
		responseDto.setMessage("feedback saved successfully.");
		return responseDto;
	}
	@Override
	public ResponseDto saveContactUs(ContactUs contactUs) {
		ResponseDto responseDto=new ResponseDto();
		contactUs.setDate(getCurrentDate());
		ContactUs Contact=	contactUsRepository.save(contactUs);
		responseDto.setError(false);
		responseDto.setStatusCode(200);
		responseDto.setMessage("Contact info saved successfully.");
		return responseDto;
	}

}
