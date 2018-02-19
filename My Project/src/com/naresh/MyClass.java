package com.naresh;

import java.util.TreeSet;

public class MyClass {

	
	public void myFunction(int[] numberArray) {
		
		TreeSet<Integer> treeSet = new TreeSet<>();
		
		int numberLength = numberArray.length;
		
		for(int i=0;i<numberLength;i++) {
			
			int number = numberArray[i];
			
			boolean  oneExist = false;
			boolean twoExist = false;
			boolean threeExist = false;
			while(number>0) {
				int remainder = number%10;
				
				if(remainder<4) {
					if(remainder==3) {
						threeExist= true;
					}
					else {
						if(remainder==2) {
							twoExist = true;
						}
						else {
							if(remainder==1) {
								oneExist = true;
							}
						}
					}
				}
				number = number/10;
			}
			
			if(oneExist && twoExist && threeExist) {
				treeSet.add(numberArray[i]);
			}
		}
		
		StringBuilder builder = new StringBuilder();
		
		for(Integer i : treeSet) {
			builder.append(i+",");
		}
		
		if(builder.length()>0)
		builder.deleteCharAt(builder.length()-1);
		System.out.println(builder.toString());
	}
	
}
