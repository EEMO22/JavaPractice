package com.javapractice.book.chapter04;

import java.util.Scanner;

public class Exercise07 {

	public static void main(String[] args) {
		boolean run = true;
		
		int balance = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.print("선택 > ");
			
			int input = 0;
			int output = 0;

			int code = scanner.nextInt();
			
			if (code == 1) {
				System.out.print("예금액> ");
				input = scanner.nextInt();
				balance += input;
			} else if (code == 2) {
				System.out.print("출금액> ");
				output = scanner.nextInt();
				balance -= output;
			} else if (code == 3) {
				System.out.print("잔고> ");
				System.out.println(balance);

			} else {
				System.out.println();
				run = false;
			}
		}
		
		
		System.out.println("프로그램 종료");
		scanner.close();
	}

}