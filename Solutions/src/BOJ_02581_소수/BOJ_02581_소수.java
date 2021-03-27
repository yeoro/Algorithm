package BOJ_02581_소수;

import java.io.*;
import java.util.*;

public class BOJ_02581_소수 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = M; i <= N; i++) {
			boolean isPrime = true;
			
			for(int j = 2; j < i; j++) {
				if(i % j == 0) {
					
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) {
				if(i != 1) {
					min = Math.min(min, i);
					sum += i;
				}
			}
		}
	
		if(sum == 0 && min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
		
		
		sc.close();
	}
}

