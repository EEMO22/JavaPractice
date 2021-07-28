package com.javapractice.book.chapter05;

public class Exercise07 {

	public static void main(String[] args) {
		int max = 0;
		int[] array = { 1, 5, 3, 8, 2 };
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] > max) {
					max = array[i];
				}
			}
		}
		
		System.out.println("max: " + max);
	}

}
