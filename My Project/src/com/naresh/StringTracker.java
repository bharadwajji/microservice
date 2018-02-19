package com.naresh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringTracker {

	
	Map<String,List<Integer>> map  = new HashMap<>(); 
	
	
	public String trackString(String[] array) {
	
		int arrayLength = array.length;
		for(int i=0;i<arrayLength;i++) {
			if(map.containsKey(array[i])) {
				List<Integer> indexList = map.get(array[i]);
				indexList.add(i);
			}
			else {
				List<Integer> indexList = new ArrayList<>();
				indexList.add(i);
				map.put(array[i],indexList);
			}
		}
		StringBuilder builder = new StringBuilder();
		for(String key : map.keySet()) {
			List<Integer> indexList = map.get(key);
			builder.append(key);
			builder.append("[");
			int indexSize =indexList.size();
			for(int i=1;i<indexSize;i++) {
				builder.append(indexList.get(i)-indexList.get(i));
				if((i+1)<indexSize) {
					builder.append(",");
				}
			}
			
			builder.append("];");
		}
		return builder.toString();
		
	}
	
}
