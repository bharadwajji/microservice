package com.naresh.airtel.maxdistinct;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MaxDistinctNumber {

	public static void main(String args[]) {

		Set<Character> set = new HashSet<>();
		Scanner scanner = new Scanner(System.in);

		int currentMaxPosition = 0;
		int currentMaxSize = 0;
		System.out.println("Please Enter Input String");

		String input = scanner.next();

		int lengthOfString = input.length();

		for (int i = 0; i < lengthOfString; i++) {
			if (set.contains(input.charAt(i))) {
				if (set.size() > currentMaxSize) {
					currentMaxSize = set.size();
				}
				currentMaxPosition = removeDuplicates(set, input, input.charAt(i), currentMaxPosition);
				set.add(input.charAt(i));
			} else {
				set.add(input.charAt(i));
			}
		}

		if (set.size() > currentMaxSize) {
			System.out.println(set.size());
		} else {
			System.out.println(currentMaxSize);
		}
	}

	public static int removeDuplicates(Set<Character> charSet, String input, Character ch, int counterToRemove) {
		if (charSet.contains(ch)) {
			charSet.remove(input.charAt(counterToRemove));
			counterToRemove++;
			return removeDuplicates(charSet, input, ch, counterToRemove);
		}
		return counterToRemove;
	}

}
