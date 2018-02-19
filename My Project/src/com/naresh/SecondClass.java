package com.naresh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecondClass {

	public int getSecondClass(String pattern) {
		
		Set<Integer> usedInteger = new HashSet<>();
		
		char[] charArray = pattern.toCharArray();
		
		int charArrayLength = charArray.length;
		
		int mainOutput = 0;
		
		if(charArray[0] == 'M') {
			mainOutput = 21;
			usedInteger.add(1);
			usedInteger.add(2);
		}
		else {
			if(charArray[0] == 'N') {
				usedInteger.add(1);
				usedInteger.add(2);
			}
			else {
				return -1;
			}
				
		}
		int i=1;
		while(i<charArrayLength) {
			
			if(charArray[i] == 'M') {
				int remainder = mainOutput % 10;
				if(!usedInteger.contains(remainder-1) && (remainder-1)>0) {
					mainOutput = (mainOutput*10)+(remainder-1);
					usedInteger.add(remainder-1);
					i++;
				}
				else {
					mainOutput = backTrack(usedInteger, mainOutput);
				}
			}
			else {
				if(charArray[i] == 'N') {
					int remainder = mainOutput % 10;
					if(!usedInteger.contains(remainder+1) && (remainder+1)<10) {
						mainOutput = (mainOutput*10)+(remainder+1);
						usedInteger.add(remainder+1);
						i++;
					}
					else {
						mainOutput = backTrack(usedInteger, mainOutput);
					}
				}
				else {
					return -1;
				}
			}
		}
	}
	
	
	public int backTrack(Set<Integer> set,int str) {
	
		String inte = str+"";
		int stringLength = inte.length();
		
		for(int i=stringLength-1;i>=0;i--) {
			
			int numeric = Character.getNumericValue(inte.charAt(i));
			int counter =1;
			while(set.contains(numeric+counter) && (numeric+counter)<10) {
				counter++;
			}
			if(numeric+counter!=10) {
				inte = inte.replace(inte.charAt(i),Character.forDigit(numeric+counter, 10));
				set.remove(numeric);
				set.add(numeric+counter);
			}
			
		}
		
		return Integer.parseInt(inte);
	}
}
