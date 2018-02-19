package com.naressh.airtel.adhar;

public class AdharModel {

	private String name;
	private String aadharNumber;
	private String address;

	public String getName() {
		return name;
	}

	public AdharModel setName(String name) {
		this.name = name;
		return this;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public AdharModel setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public AdharModel setAddress(String address) {
		this.address = address;
		return this;
	}

}
