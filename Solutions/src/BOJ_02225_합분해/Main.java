package BOJ_02225_�պ���;

import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[K+1][N+1];
		
		for(int i = 1; i <= K; i++) {
			dp[i][0] = 1;
		}
		
		for(int i = 1; i <= K; i++) {
			for(int j = 1; j <= N; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
			}
		}
		
		System.out.println(dp[K][N]);
		
		br.close();
	}
}

