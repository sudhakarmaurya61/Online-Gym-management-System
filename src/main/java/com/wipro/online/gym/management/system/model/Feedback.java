package com.wipro.online.gym.management.system.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="feedback",catalog = "gym_management")
public class Feedback implements Serializable{
	
	private static final long serialVersionUID = -7588856363586399561L;
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="user_id")
	private Integer userId;
	@Column(name="message")
	private String feedback;
	@Column(name="feedback_time")
	private String date;
	@Column(name="rating")
	private Integer rating;
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
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Feedback(Integer id, Integer userId, String feedback, String date, Integer rating) {
		super();
		this.id = id;
		this.userId = userId;
		this.feedback = feedback;
		this.date = date;
		this.rating = rating;
	}
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", userId=" + userId + ", feedback=" + feedback + ", date=" + date + ", rating="
				+ rating + "]";
	}
	
	

	

}
