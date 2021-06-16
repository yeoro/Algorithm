package BOJ_09461_�ĵ��ݼ���;

import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		long[] dp = new long[101];
		
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i = 4; i <= 100; i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			System.out.println(dp[N]);
		}
		
		sc.close();
	}
}