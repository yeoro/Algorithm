package BOJ_11653_소인수분해;

import java.util.Scanner;

public class BOJ_11653_소인수분해 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if(N == 1) {
			return;
		}
		
		for(int i = 2; i <= N; i++) {
			if(N % i == 0) {
				System.out.println(i);
				N /= i;
				if(N == 1) {
					break;
				} else {
					--i;
					continue;
				}
			}
		}
		
		sc.close();
	}
}

