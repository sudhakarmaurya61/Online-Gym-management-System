/**
 * 
 */
package com.wipro.online.gym.management.system.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * 12-09-2024
 * @author Sudhakar Maurya
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto implements Serializable{
	private static final long serialVersionUID = -1472687310608287221L;
	private int statusCode;
    private boolean error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private Object objectData;
    private Object bookingData;
    private Object packageData;
    private Object trainer;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public boolean getError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}
	public Object getObjectData() {
		return objectData;
	}
	public void setObjectData(Object objectData) {
		this.objectData = objectData;
	}
	
	public Object getBookingData() {
		return bookingData;
	}
	public void setBookingData(Object bookingData) {
		this.bookingData = bookingData;
	}
	public Object getTrainer() {
		return trainer;
	}
	public void setTrainer(Object trainer) {
		this.trainer = trainer;
	}
	@Override
	public String toString() {
		return "ResponseDto [statusCode=" + statusCode + ", error=" + error + ", message=" + message + ", token="
				+ token + ", refreshToken=" + refreshToken + ", expirationTime=" + expirationTime + ", objectData="
				+ objectData + ", bookingData=" + bookingData + ", trainer=" + trainer + "]";
	}
	public Object getPackageData() {
		return packageData;
	}
	public void setPackageData(Object packageData) {
		this.packageData = packageData;
	}
	
	
}
