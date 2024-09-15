package com.wipro.online.gym.management.system.dto;

public class UserDTO {
private int id;
private String name;
private String email;
private String role;
private String address;
private String contact;
private String password;
private String slotTime;
private Integer packageId;
private Integer trainerId;
private Integer age;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public String getSlotTime() {
	return slotTime;
}
public void setSlotTime(String slotTime) {
	this.slotTime = slotTime;
}
public Integer getPackageId() {
	return packageId;
}
public void setPackageId(Integer packageId) {
	this.packageId = packageId;
}
public Integer getTrainerId() {
	return trainerId;
}
public void setTrainerId(Integer trainerId) {
	this.trainerId = trainerId;
}

	
}
