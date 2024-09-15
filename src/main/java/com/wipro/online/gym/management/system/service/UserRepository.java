package com.wipro.online.gym.management.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.online.gym.management.system.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findByEmail(String email);
	User findByEmailAndPassword(String email, String password);
	Optional<User> findById(Integer Id);
	

}
