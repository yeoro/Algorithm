package day01_recursive;

import java.util.Scanner;

public class FiboMemo {
	
	static long[] fibo1, fibo2, memo;
	static long totalCnt1, totalCnt2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		fibo1 = new long[N+1];
		fibo2 = new long[N+1];
		memo = new long[N+1];
		
		System.out.println(fibonacci(N));
		for(int i = 0; i < N; i++) {
			System.out.println(i + " : " + fibo1[i]);
		}
		System.out.println("fibo1 total : " + totalCnt1);
		System.out.println("==============================");
		System.out.println(fibonacci2(N));
		for(int i = 0; i < N; i++) {
			System.out.println(i + " : " + fibo2[i]);
		}
		System.out.println("fibo2 total : " + totalCnt2);
		sc.close();
	}
	
	private static long fibonacci(int n) {
		++fibo1[n];
		++totalCnt1;
		
		if(n <= 1) {
			return n;
		}
		
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	private static long fibonacci2(int n) {
		++fibo2[n];
		++totalCnt2;
		
		if(n <= 1) {
			return n;
		}
		
		// n항의 값을 계산한 적이 있다면 메모된 값 리턴
		if(memo[n] != 0) {
			return memo[n];
		}
		
		return memo[n] = fibonacci2(n - 1) + fibonacci2(n - 2);
	}
}
