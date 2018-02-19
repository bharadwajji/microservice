package com.naressh.airtel.adhar;

import java.util.ArrayList;
import java.util.List;

public class AadharApi {


	private RequestValidator validator = new RequestValidator();
	
	public AdharModel getAdharData(RequestModel requestModel) {
		return validator.chechRequestValidity(requestModel);
	}
	
	
	public List<String> getRejectedRequestTopContestants(){
		
		List<String> list = new ArrayList<>();
		int count = 0;
		
		for(RateRejectedReport report : validator.getReport().keySet()) {
			if(count<10) {
				list.add(report.getUserName());
				count++;
			}
			else {
				break;
			}
			
		}
		
		return list;
	}
	
}
