package BOJ_01463_1로만들기;

import java.io.*;
import java.util.*;

class Main {
	
	static int[] dp;
	static int N, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[1000001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[1] = 0;
		dp[2] = 1;
		
		for(int i = 3; i <= N; i++) {
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
			
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
			
			dp[i] = Math.min(dp[i], dp[i-1]+1);
		}
		
		System.out.println(dp[N]);
		
		br.close();
	}
}

