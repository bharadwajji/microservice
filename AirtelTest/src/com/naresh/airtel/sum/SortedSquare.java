package com.naresh.airtel.sum;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SortedSquare {

	
	public static void main(String args[]) {
	
		Set<Integer> sortedSet = new TreeSet<>();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Total Number of Integer");
		
		int inputCount = scanner.nextInt();
		if(inputCount>0) {
			System.out.println("Provide Input in Sorted Order");
			for(int i=0;i<inputCount;i++) {
				int input = scanner.nextInt();
				sortedSet.add(input*input);
			}
			
			for(Integer output : sortedSet) {
				System.out.println(output);
			}
			
		}
		else {
			System.out.println("Invalid Input");
		}
		
		
		
	}
}
