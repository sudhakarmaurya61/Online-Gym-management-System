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


@Entity
@Table(name="trainer",catalog = "gym_management")
public class Trainner implements Serializable{

	private static final long serialVersionUID = 7420583118907462254L;
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="trainer_name")
	private String trainerName;
	@Column(name="trainer_certificate")
	private String trainnerCrfct;
	@Column(name="trainer_exp")
	private String trainerExp;
	@Column(name="trainner_type")
	private String trainnerType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getTrainnerCrfct() {
		return trainnerCrfct;
	}
	public void setTrainnerCrfct(String trainnerCrfct) {
		this.trainnerCrfct = trainnerCrfct;
	}
	public String getTrainerExp() {
		return trainerExp;
	}
	public void setTrainerExp(String trainerExp) {
		this.trainerExp = trainerExp;
	}
	public String getTrainnerType() {
		return trainnerType;
	}
	public void setTrainnerType(String trainnerType) {
		this.trainnerType = trainnerType;
	}
	public Trainner(Integer id, String trainerName, String trainnerCrfct, String trainerExp, String trainnerType) {
		super();
		this.id = id;
		this.trainerName = trainerName;
		this.trainnerCrfct = trainnerCrfct;
		this.trainerExp = trainerExp;
		this.trainnerType = trainnerType;
	}
	public Trainner() {
		super();
		// TODO Auto-generated constructor stub
	}

}
