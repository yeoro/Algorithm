package BOJ_01929_소수구하기;

import java.util.Scanner;

public class BOJ_01929_소수구하기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		loop:for(int i = M; i <= N; i++) {
			if(i == 1) {
				continue;
			}
			
			if(i % 2 == 0) {
				if(i == 2) {
					sb.append(2 + "\n");
				} 
				continue;
			}
			
			for(int j = 3; j <= Math.sqrt(i); j+=2) {
				if(i % j == 0) {
					continue loop;
				}
			}
			
			sb.append(i + "\n");
		}
		
		System.out.println(sb);
		sc.close();
	}
}

