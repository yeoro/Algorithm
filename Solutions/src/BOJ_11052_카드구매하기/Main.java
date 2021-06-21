package BOJ_11052_카드구매하기;

import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] price = new int[N+1];
		int[][] dp = new int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i <= j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-i]+price[i]);
				} else {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
				}
			}
		}
		
		System.out.println(dp[N][N]);
			
		br.close();
	}
}

