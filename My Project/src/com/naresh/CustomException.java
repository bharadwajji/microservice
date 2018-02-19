package com.naresh;

import java.util.HashSet;
import java.util.Set;

public class CustomException {

	
	private Integer[] array = new Integer[10];
	private Set<Integer> set = new HashSet<>();
	
	
	class InvalidElement extends Exception{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public InvalidElement(String message) {
			super(message);
		}
		
		public InvalidElement(Throwable e) {
			super(e);
		}
		
		public InvalidElement(Throwable e,String message) {
			super(message,e);
		}
	}
	
	class ElementDuplication extends Exception{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		
		public ElementDuplication(String message) {
			super(message);
		}
		
		public ElementDuplication(Throwable e) {
			super(e);
		}
		
		public ElementDuplication(Throwable e,String message) {
			super(message,e);
		}
	}
	
	class ArraySizeExceeded extends Exception{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public ArraySizeExceeded(String message) {
			super(message);
		}
		
		public ArraySizeExceeded(Throwable e) {
			super(e);
		}
		
		public ArraySizeExceeded(Throwable e,String message) {
			super(message,e);
		}
		
	}
	
	public void insertElement(Integer element) throws InvalidElement, ElementDuplication, ArraySizeExceeded {
		
		if(element<0) {
			throw new InvalidElement("Invalid Element Exist");
		}
		if(set.contains(element)) {
			throw new ElementDuplication("Element Already Exist");
		}
		if(array.length==10) {
			throw new ArraySizeExceeded("Array Already Filled");
		}
		
		array[array.length] = element;
		set.add(element);
	}
}
