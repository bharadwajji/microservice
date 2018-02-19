package com.naressh.airtel.adhar;

public class RequestModel {

	private String userName;
	private String dateOfRequest = "date "+System.currentTimeMillis();
	private String aadharInfo = "default";
	private Integer requestAllowedPerMinute = 10;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDateOfRequest() {
		return dateOfRequest;
	}
	public void setDateOfRequest(String dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}
	public String getAadharInfo() {
		return aadharInfo;
	}
	public void setAadharInfo(String aadharInfo) {
		this.aadharInfo = aadharInfo;
	}
	public Integer getRequestAllowedPerMinute() {
		return requestAllowedPerMinute;
	}
	public void setRequestAllowedPerMinute(Integer requestAllowedPerMinute) {
		this.requestAllowedPerMinute = requestAllowedPerMinute;
	}
}
