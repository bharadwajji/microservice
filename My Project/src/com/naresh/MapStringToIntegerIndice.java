package com.naresh;

import java.util.HashMap;
import java.util.Map;

public class MapStringToIntegerIndice {
	
	private static Map<String,Integer> map = new HashMap<>();
	
	static {
		map.put("IN", 0);
		map.put("EU", 2);
		map.put("US", 1);
		map.put("RU", 3);
	}
	public static void main(String args[]) {
		
		String[] array = {"IN", "EU", "US", "EU", "IN", "RU", "IN", "RU", "US", "EU"};
		
		System.out.println(mapStringToIntegerIndices(array));
	}
	
	public static Integer[] mapStringToIntegerIndices(String[] array) {
		
		int arrayLength = array.length;
		
		Integer[] indiceArray = new Integer[arrayLength];
		
		for(int i=0;i<arrayLength;i++) {
			if(map.containsKey(array[i])) {
				indiceArray[i]=map.get(array[i]);
			}
		}
		
		return indiceArray;
	}

}
