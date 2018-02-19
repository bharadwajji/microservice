package com.naressh.airtel.adhar;

import java.util.concurrent.atomic.AtomicInteger;

public class RateRejectedReport implements Comparable<RateRejectedReport> {

	private final String userName;
	private AtomicInteger count = new AtomicInteger(1);

	public RateRejectedReport(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}

	public AtomicInteger getCount() {
		return count;
	}

	public void setCount(AtomicInteger count) {
		this.count = count;
	}
	
	@Override
	public int hashCode() {
		return userName.hashCode();
	}
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof RateRejectedReport) {
			
			RateRejectedReport report = (RateRejectedReport) object;
			if(this.userName.equals(report.getUserName())) {
				return true;
			}
			
		}
		return false;
	}
	@Override
	public int compareTo(RateRejectedReport object) {
		// TODO Auto-generated method stub
		return this.count.intValue()>=object.getCount().intValue() ? 1 : -1;
	}
}
