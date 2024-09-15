/**
 * 
 */
package com.wipro.online.gym.management.system.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**15-09-2024
 * @author Sudhakar Maurya
 */
@Entity
@Table(name="contact_us",catalog = "gym_management")
public class ContactUs implements Serializable {
	private static final long serialVersionUID = -5339729409348810420L;
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="user_email")
	private String email;
	@Column(name="message")
	private String message;
	@Column(name="contact_time")
	private String date;
	@Column(name="mobile")
	private String mobileNo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public ContactUs(Integer id, String email, String message, String date, String mobileNo) {
		super();
		this.id = id;
		this.email = email;
		this.message = message;
		this.date = date;
		this.mobileNo = mobileNo;
	}
	public ContactUs() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
