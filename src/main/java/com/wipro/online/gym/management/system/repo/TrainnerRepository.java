package com.wipro.online.gym.management.system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.online.gym.management.system.model.Trainner;

public interface TrainnerRepository extends JpaRepository<Trainner, Integer>{

	Trainner getTrainerById(Integer trainerId);

}
