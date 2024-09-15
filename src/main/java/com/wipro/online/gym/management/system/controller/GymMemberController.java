package com.wipro.online.gym.management.system.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.online.gym.management.system.dto.ResponseDto;
import com.wipro.online.gym.management.system.dto.UserDTO;
import com.wipro.online.gym.management.system.model.ContactUs;
import com.wipro.online.gym.management.system.model.Feedback;
import com.wipro.online.gym.management.system.model.Trainner;
import com.wipro.online.gym.management.system.service.IUserInterface;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class GymMemberController {
	
	private static final Logger logger=Logger.getLogger(GymMemberController.class);
	@Autowired
	IUserInterface iUserInterface;
	
	@PostMapping("/index")
	public Object getLoginPage()
{
		System.err.println("index Page Load");
		
	return "API is Working.....";
}
	@PostMapping("/sign-up")
	public ResponseDto registerUser(@RequestBody UserDTO userDTO) {
		logger.info("sign-up API is calling ::::::::::::::"+userDTO.toString());
		ResponseDto user=iUserInterface.saveUserDetails(userDTO);
		logger.info("sign-up API reponse:::::::"+user.toString() );
		return user;
	}
	@PostMapping("/login")
	public ResponseDto loginUser(@RequestBody UserDTO userDto)
	{
		logger.info("login API calling :::::::::::");
		ResponseDto userResponse=iUserInterface.loginUser(userDto);
		logger.info("login API response :::::::::::"+userResponse.toString());
		return userResponse;
	}
	
	@PostMapping("/find-by-userid")
	public ResponseDto findByUserId(@RequestBody UserDTO userDto)
	{
		logger.info("find-by-userid API Calling ::::::::::::::"+userDto.toString());
		ResponseDto userResponse=iUserInterface.findByUserId(userDto);
		logger.info("find-by-userid API response::::::::::::"+userResponse.toString());
		return userResponse;
	}
   @PutMapping("/reset-password")
   public ResponseDto resetPassword(@RequestBody UserDTO userDto) {
	   logger.info("reset-password API Calling ::::::::::"+userDto.toString());
	   ResponseDto userResponse=iUserInterface.resetUserPassword(userDto);  
	   logger.info("reset-password API Response::::"+userResponse.toString());
       return userResponse;
   }
    @PostMapping("/get-package")
    public ResponseDto getMethodName() {
    	logger.info("get-package API calling :::::;");
    	ResponseDto responseDto=iUserInterface.getPackgeDetails();
    	logger.info("get-package API Respone::::::::"+responseDto.toString());
        return responseDto;
    }
    
    @PostMapping("/slot-booking")
    public ResponseDto slotBokking(@RequestBody UserDTO userDto) {
    	logger.info("slot-booking API Calling :::::::::::"+userDto.toString());
    	ResponseDto responseDto=iUserInterface.savePackage(userDto);
    	logger.info("slot-booking API response:::::::::"+responseDto.toString());
        return responseDto;
    }
    @GetMapping("/get-all-trainer")
    public ResponseDto getAllTrainner() {
    	logger.info("get-all-trainer API calling :::::");
    	ResponseDto responseDto=iUserInterface.getAllTrainer();
    	logger.info("get-all-trainer API Respone::::::::"+responseDto.toString());
        return responseDto;
    }
    @PostMapping("/trainer-info")
    public ResponseDto getTrainerById(@RequestBody UserDTO userDto)
    {
    	logger.info("trainer-info API is calling ::::::::::"+userDto.toString());
    	ResponseDto responseDto=iUserInterface.findTrainnerDetails(userDto.getTrainerId());
    	logger.info("trainer-info API Response::::::::::"+responseDto.toString());
		return responseDto;
    }
    @PostMapping("/add-trainner")
    public ResponseDto addTrainner(@RequestBody Trainner trainner)
    {
    	logger.info("add-trainner API is calling :::::::::::"+trainner.toString());
    	ResponseDto responseDto=iUserInterface.addTrainner(trainner);
    	logger.info("add-trainner API is response :::::::::::"+responseDto.toString());
		return responseDto;
    }
    @PostMapping("/delete-trainner")
    public ResponseDto deleteTrainner(@RequestBody Trainner trainner)
    {
    	logger.info("delete-trainner API is calling :::::::::::"+trainner.toString());
    	ResponseDto responseDto=iUserInterface.deleteTrainner(trainner);
    	logger.info("delete-trainner API response ::::::::::"+responseDto.toString());
		return responseDto;
    }
    @PostMapping("/get-admin-dashboard")
    public List<ResponseDto> getAdminDashboardData() {
    	logger.info("get-admin-dashboard API is calling ::::::::::::");
    	List<ResponseDto> responseDto =iUserInterface.getDashboardData();
    	logger.info("get-admin-dashboard API Response ::::::::::::"+responseDto.toString());
        return responseDto;
    }
    @PostMapping("/save-user-feedback")
    public ResponseDto saveUserFeedback(@RequestBody Feedback feedback) {
    	logger.info("save-user-feedback API is calling ::::::::::::"+feedback.toString());
    	ResponseDto responseDto =iUserInterface.saveUserFeedback(feedback);
    	logger.info("save-user-feedback API Response ::::::"+responseDto.toString());
        return responseDto;
    }
    @PostMapping("/contact-us")
    public ResponseDto saveContactUs(@RequestBody ContactUs contactUs) {
    	logger.info("contact-us API is calling :::::::::::"+contactUs.toString());
    	ResponseDto responseDto =iUserInterface.saveContactUs(contactUs);
    	logger.info("contact-us API response ::::::::::"+responseDto.toString());
        return responseDto;
    }
}
