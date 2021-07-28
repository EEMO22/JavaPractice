package com.javapractice.book.chapter04;

public class Exercise05 {

	public static void main(String[] args) {
		
		int x = 0;
		int y = 0;
		
		for(x = 1; x < 11; x++) {
			for(y = 1; y < 11; y++) {
				if ((x * 4) + (y * 5) == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
		}
		
	}

}