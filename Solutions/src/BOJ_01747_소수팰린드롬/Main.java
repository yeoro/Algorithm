package BOJ_01747_소수팰린드롬;

import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		loop: while(true) {
			double n = Math.sqrt(N);
			
			for(int i = 2; i <= n; i++) {
				if(N % i == 0) {
					N++;
					continue loop;
				}
			}
			
			StringBuilder sb = new StringBuilder(Integer.toString(N));
			
			if(sb.toString().equals(sb.reverse().toString())) {
				break;
			}
			
			N++;
		}
		
		if(N == 1) {
			System.out.println(2);
		} else {
			System.out.println(N);
		}
		
		sc.close();
	}
}

