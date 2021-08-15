package com.javapractice.note;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Note00 {	//	구름 시험성적 평균과 등급 구하기
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int subCount = 3;
		int sum = 0;
		
			String[] p = br.readLine().split(" ");
			
			for(int i = 0; i < subCount; i++) {
				sum += Integer.parseInt(p[i]);
			}

		float avg = (float)sum / subCount;
		char grade;
		
		if (avg >= 90){
			grade = 'A';
		} else if (avg >= 80) {
			grade = 'B';
		} else if (avg >= 70) {
			grade = 'C';
		} else if (avg >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		System.out.printf("%.2f %c", avg, grade);
		br.close();
	}
}