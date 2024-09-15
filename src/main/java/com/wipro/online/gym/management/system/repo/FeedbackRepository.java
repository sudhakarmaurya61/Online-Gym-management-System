package com.wipro.online.gym.management.system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.online.gym.management.system.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{

}
