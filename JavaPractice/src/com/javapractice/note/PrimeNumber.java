package com.javapractice.note;

import java.util.Scanner;

public class PrimeNumber {
	//	Prime Number, 소수를 구해봅시다.
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.print("숫자를 입력해 주세요: ");
	int num= sc.nextInt();
	
//	pNum1(num);		//	O(n) 소수 판별
//	getPnum1(num);	//	O(n^2) n 이하 모든 소수 찾기
	
//	pNum2(num);		//	O(√n) 소수 판별
//	getPnum2(num);	//	O(n√n) n 이하 모든 소수 찾기
	
	pNum0(num);		//	O(nlog(logn)) 에라토스체네스의 체
	
	sc.close();
	}

	
	//	간단한 소수 판별
	private static void pNum1(int num) {
		//	명확한 숫자들
		if (num < 2) {							//	0과 1은 소수가 아니다
			System.out.println("소수가 아닙니다.");
			return;
		} else if (num == 2) {					//	2는 소수다
			System.out.println("소수입니다.");
			return;
		} 
		
		//	소수 찾기
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				System.out.println("소수가 아닙니다.");
				return;
			} else {
				System.out.println("소수입니다.");
				return;
			}
		}	
	}	//	2 이상 n 미만의 수 중 나누어 떨어지면 자기 자신 이외의 약수가 존재하므로 소수가 아님u
		//	n 이하의 모든 수를 검사하므로 
		//	시간복잡도는 O(n)
	
	//	n 이하의 모든 소수 구하기
	private static void getPnum1(int num) {
		if (num < 2) {
			System.out.println("없음");
			return;
		} else if (num == 2) {
			System.out.println(num);
			return;
		} 
		for (int i = 2; i <= num; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.println(i);
			} 
		}
	}	//	n이하의 모든 수를 검사하는 O(n)을 n번 더 반복하여 재검사하므로
		//	시간복잡도는 O(n^2)
	
	//	√n 이하의 자연수로 나눠보기
	
	//	임의의 자연수 n에 대해, p * q = n 일 때,
	//	p의 증가는 q의 감소이다
	//	p와 q 중 어느 하나는 반드시 √n 보다 작거나 같다
	//	즉, √n 이하의 자연수 중 N을 나누어 떨어뜨릴 수 있는 수는 이는 N의 또다른 약수이다
	//	그러므로 n이하의 소수를 구하기 위해 n이하의 모든 수를 검사하는 판별식에서
	//	√n이하의 모든 수를 검사하도록 시행 횟수를 줄일 수 있다
	
	private static void pNum2(int num) {
		//		명확한 숫자들
		if (num < 2) {							//	0과 1은 소수가 아니다
			System.out.println("소수가 아닙니다.");
			return;
		} else if (num == 2) {					//	2는 소수다
			System.out.println("소수입니다.");
			return;
		}
		 
		for (int i = 2; i < Math.sqrt(num); i++) {	//	Math.sqrt() 제곱근 함수
			if (num % i == 0) {
				System.out.println("소수가 아닙니다.");
				return;
			} else {
				System.out.println("소수입니다.");
				return;
			}
		}
	}	//	√n 이하의 모든 수를 검사하므로
		//	시간복잡도는 O(√n)
	
	//	√n 을 이용한 n 이하의 모든 소수 구하기
	private static void getPnum2(int num) {
		if (num < 2) {
			System.out.println("없음");
			return;
		} else if (num == 2) {
			System.out.println(num);
			return;
		}
		for (int i = 2; i <= num; i++) {
			boolean isPrime = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.println(i);
			} 
		}
	}
	//	i는 n 이하의 수를 검사하므로, √i의 시행횟수는 √n의 시행횟수에 비례
	//	따라서 이중 for문에 의해 i, n번의 검사와 j, √i번의 검사를 수행하므로
	//	시간복잡도는 O(n√n)  
	
	//	에라토스테네스의 체
	//	자연수들 중 k = 2 부터 √n 이하까지 k를 제외한 k의 배수들을 제외시켜나간다
	private static void pNum0(int num) {
		
		boolean[] prime = new boolean[num + 1];		//	0 ~ n 까지 소수를 체크할 배열
		
		//	소수 index = false, 소수가 아닌 index = true;
		
		if (num < 2) {								//	2 미만의 n은 판별 대상이 아님
			System.out.println("없음");
			return;
		}
		
		prime[0] = prime[1] = true;					//	0과 1의 미출력 처리
		
		for (int i = 2; i <= Math.sqrt(num); i++) {	//	제곱근을 이용한 소수 판별
			if (prime[i] == true) {		//	이미 판별 된 수에 대해서는 건너뛴다
				continue;
			}
			
			for (int j = i*i; j < prime.length; j = j+i) {	//	i 의 배수 제외하기
				prime[j] = true;
			}
		}
		
		for (int i = 0; i < prime.length; i++) {	//	소수인 경우 출력
			if (prime[i] == false){
				System.out.println(i);
			}
		}
	}
	
	//	boolean[] prime 배열에는 [i]번 자연수에 대해 소수 여부가 true or false로 저장된다
	//	0과 1은 언제나 해당 사항 없으므로 예외로 처리한다
	//	2 이상의 자연수 n 에 대해 √n 의 범위에서 소수를 판별한다
	//	n 이하의 자연수 i 에 대해 i의 배수는 이미 prime 배열에 소수 여부가 입력되어 있으니 제외한다
	//	4의 배수들은 2의 배수, 9의 배수는 3의 배수인 것과 마찬가지로 i에 대한 중복 배수가 제외된다
	//	중복을 걸러내며 시행횟수를 줄이는 것이 핵심이다
	//	저장된 배열에서 소수 여부에 따라 출력한다
}
