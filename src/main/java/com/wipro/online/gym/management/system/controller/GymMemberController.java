package com.wipro.online.gym.management.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.online.gym.management.system.dto.ResponseDto;
import com.wipro.online.gym.management.system.dto.UserDTO;
import com.wipro.online.gym.management.system.model.ContactUs;
import com.wipro.online.gym.management.system.model.Feedback;
import com.wipro.online.gym.management.system.model.Trainner;
import com.wipro.online.gym.management.system.service.IUserInterface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class GymMemberController {
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
		//TODO: process POST request
		ResponseDto user=iUserInterface.saveUserDetails(userDTO);
		return user;
	}
	@PostMapping("/login")
	public ResponseDto loginUser(@RequestBody UserDTO userDto)
	{
		ResponseDto userResponse=iUserInterface.loginUser(userDto);
		return userResponse;
	}
	
	@PostMapping("/find-by-userid")
	public ResponseDto findByUserId(@RequestBody UserDTO userDto)
	{
		ResponseDto userResponse=iUserInterface.findByUserId(userDto);
		return userResponse;
	}
   @PutMapping("/reset-password")
   public ResponseDto resetPassword(@RequestBody UserDTO userDto) {
	   ResponseDto userResponse=iUserInterface.resetUserPassword(userDto);  
       return userResponse;
   }
    @PostMapping("/get-package")
    public ResponseDto getMethodName() {
    	ResponseDto responseDto=iUserInterface.getPackgeDetails();
        return responseDto;
    }
    
    @PostMapping("/slot-booking")
    public ResponseDto slotBokking(@RequestBody UserDTO userDto) {
    	ResponseDto responseDto=iUserInterface.savePackage(userDto);
        return responseDto;
    }
    
    @PostMapping("/trainer-info")
    public ResponseDto getTrainerById(@RequestBody UserDTO userDto)
    {
    	ResponseDto responseDto=iUserInterface.findTrainnerDetails(userDto.getTrainerId());
		return responseDto;
    }
    @PostMapping("/add-trainner")
    public ResponseDto addTrainner(@RequestBody Trainner trainner)
    {
    	ResponseDto responseDto=iUserInterface.addTrainner(trainner);
		return responseDto;
    }
    @PostMapping("/delete-trainner")
    public ResponseDto deleteTrainner(@RequestBody Trainner trainner)
    {
    	ResponseDto responseDto=iUserInterface.deleteTrainner(trainner);
		return responseDto;
    }
    @PostMapping("/get-admin-dashboard")
    public List<ResponseDto> getAdminDashboardData() {
    	List<ResponseDto> responseDto =iUserInterface.getDashboardData();
        return responseDto;
    }
    @PostMapping("/save-user-feedback")
    public ResponseDto saveUserFeedback(@RequestBody Feedback feedback) {
    	ResponseDto responseDto =iUserInterface.saveUserFeedback(feedback);
        return responseDto;
    }
    @PostMapping("/contact-us")
    public ResponseDto saveContactUs(@RequestBody ContactUs contactUs) {
    	ResponseDto responseDto =iUserInterface.saveContactUs(contactUs);
        return responseDto;
    }
}
