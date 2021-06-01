package BOJ_09084_µ¿Àü;

import java.io.*;
import java.util.*;

class Main {
	
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			
			int[] w = new int[N+1];
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 1; i <= N; i++) {
				w[i] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			
			dp = new int[N+1][M+1];
			
			for(int i = 0; i <= N; i++) {
				dp[i][0] = 1;
			}
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					if(w[i] <= j) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j] + dp[i][j-w[i]]);
					} else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
			
			System.out.println(dp[N][M]);
		}		
		
		br.close();
	}
}

