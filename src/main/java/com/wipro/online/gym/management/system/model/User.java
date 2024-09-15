package com.wipro.online.gym.management.system.model;

import java.io.Serializable;

import jakarta.persistence.*;



@Entity
@Table(name="user",catalog = "gym_management")
public class User implements Serializable{
	
	private static final long serialVersionUID = 2526282455461313078L;
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String email;
	private String address;
	private String contact;
	private Integer age;
	private String password;
	private String role;
	public User() {
		
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, String email, String address, String contact, Integer age, String password,String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.contact = contact;
		this.age = age;
		this.password = password;
		this.setRole(role);
	}


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


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", contact="
				+ contact + ", age=" + age + ", password=" + password + "]";
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
}
   
