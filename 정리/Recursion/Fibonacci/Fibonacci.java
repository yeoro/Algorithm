package day01_recursive;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(fibonacci(N));
		
		sc.close();
	}
	
	private static long fibonacci(int n) {
		if(n <= 1) {
			return n;
		}
		
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

}
