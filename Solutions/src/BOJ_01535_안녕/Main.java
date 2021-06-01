package BOJ_01535_¾È³ç;

import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] L = new int[N+1];
		int[] J = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}
				
		int[][] dp = new int[N+1][101];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= 100; j++) {
				if(j - L[i] > 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-L[i]] + J[i]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[N][100]);
		
		br.close();
	}
}