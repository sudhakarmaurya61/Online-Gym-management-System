package com.wipro.online.gym.management.system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.online.gym.management.system.model.SlotBooking;

public interface SlotbookingRepository extends JpaRepository<SlotBooking, Integer>{

	List<SlotBooking> getSlotBookingByUserId(int id);

	List<SlotBooking> getSlotBookingByUserIdAndStatus(int id, int i);

}
