package BOJ_02293_µ¿Àü1;

import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n+1][k+1];
		int[] coin = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 1; i <= n; i++) {
			dp[i][0] = 1;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= k; j++) {
				if(coin[i] <= j) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + dp[i][j-coin[i]]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[n][k]);
		
		br.close();
	}
}