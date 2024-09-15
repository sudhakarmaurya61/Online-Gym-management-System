package com.wipro.online.gym.management.system.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="slot_booking",catalog = "gym_management")
public class SlotBooking implements Serializable {
	private static final long serialVersionUID = -7169348892452205204L;
	@Id
	@GeneratedValue
	@Column(name="id")
    private Integer id;
	@Column(name="user_id")
    private Integer userId;
	@Column(name="package_id")
    private Integer packageId;
	@Column(name="slot_time")
    private String slotTime;
	@Column(name="booking_date")
    private String bookingDate;
	@Column(name="trainer_id")
    private Integer trainerId;
	@Column(name="status")
    private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getPackageId() {
		return packageId;
	}
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	public String getSlotTime() {
		return slotTime;
	}
	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Integer getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public SlotBooking(Integer id, Integer userId, Integer packageId, String slotTime, String bookingDate,
			Integer trainerId, Integer status) {
		super();
		this.id = id;
		this.userId = userId;
		this.packageId = packageId;
		this.slotTime = slotTime;
		this.bookingDate = bookingDate;
		this.trainerId = trainerId;
		this.status = status;
	}
	public SlotBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
