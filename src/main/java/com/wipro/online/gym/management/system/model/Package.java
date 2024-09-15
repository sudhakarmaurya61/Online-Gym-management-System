/**
 * 
 */
package com.wipro.online.gym.management.system.model;

import java.io.Serializable;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/** 14-09-2024
 * @author Sudhakar Maurya
 */
@Entity
@Table(name="package",catalog = "gym_management")
public class Package implements Serializable{

	private static final long serialVersionUID = 7899728413365515646L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="package")
	private String packageName;
	@Column(name="price")
	private String price;
	
	public Package() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Package(Integer id, String packageName, String price) {
		super();
		this.id = id;
		this.packageName = packageName;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
