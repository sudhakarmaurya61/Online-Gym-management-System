package com.wipro.online.gym.management.system.service;

import java.util.List;

import com.wipro.online.gym.management.system.dto.ResponseDto;
import com.wipro.online.gym.management.system.dto.UserDTO;
import com.wipro.online.gym.management.system.model.ContactUs;
import com.wipro.online.gym.management.system.model.Feedback;
import com.wipro.online.gym.management.system.model.Trainner;

public interface IUserInterface {

	ResponseDto saveUserDetails(UserDTO userDTO);

	ResponseDto loginUser(UserDTO userDto);

	ResponseDto findByUserId(UserDTO userDto);

	ResponseDto resetUserPassword(UserDTO userDto);

	ResponseDto getPackgeDetails();

	ResponseDto savePackage(UserDTO userDto);

	ResponseDto findTrainnerDetails(Integer trainerId);

	ResponseDto addTrainner(Trainner trainner);

	ResponseDto deleteTrainner(Trainner trainner);

	List<ResponseDto> getDashboardData();

	ResponseDto saveUserFeedback(Feedback feedback);

	ResponseDto saveContactUs(ContactUs contactUs);

	ResponseDto getAllTrainer();

}
