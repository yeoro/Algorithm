package BOJ_02579_계단오르기;

import java.io.*;
import java.util.*;

class Main {
	
	static int[][] dp;
	static int[] score;
	static int N, max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		score = new int[N+1];
		dp = new int[N+1][2];
		
		for(int i = 1; i <= N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1][0] = score[1];
		dp[1][1] = 0;
		
		for(int i = 2; i <= N; i++) {
			dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + score[i];
			dp[i][1] = dp[i-1][0] + score[i];
		}
		
		System.out.println(Math.max(dp[N][0], dp[N][1]));
		
		br.close();
	}
}

