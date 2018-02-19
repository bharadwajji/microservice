package com.naressh.airtel.adhar;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class RequestValidator {

	private static ConcurrentHashMap<String, CacheConcurrentHashMap<String, Object>> cache = new ConcurrentHashMap<>();

	private static Map<RateRejectedReport, RateRejectedReport> set = new TreeMap<>();

	public AdharModel chechRequestValidity(RequestModel requestModel) {

		if (cache.containsKey(requestModel.getUserName())) {
			if (cache.get(requestModel.getUserName()).size() > requestModel.getRequestAllowedPerMinute()) {
				RateRejectedReport rateRejectedReport = new RateRejectedReport(requestModel.getUserName());
				if (set.containsKey(rateRejectedReport)) {
					set.get(rateRejectedReport).getCount().getAndIncrement();
				}
				throw new RuntimeException("User Request limit Exceeded");
			} else {
				cache.get(requestModel.getUserName()).put(requestModel.getDateOfRequest(), new Object());
				return new AdharModel().setName(requestModel.getUserName());
			}
		} else {
			CacheConcurrentHashMap<String, Object> cacheMap = new CacheConcurrentHashMap<>(60000);
			cacheMap.put(requestModel.getDateOfRequest(), new Object());
			cache.put(requestModel.getUserName(), cacheMap);
			return new AdharModel().setName(requestModel.getUserName());
		}

	}

	public Map<RateRejectedReport, RateRejectedReport> getReport() {

		return set;
	}
}
