package BOJ_10942_팰린드롬;

import java.io.*;
import java.util.*;

class Main {
	
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N+1][N+1];
		
		// 길이가 1인 수
		for(int i = 1; i <= N; i++) {
			dp[i][i] = 1;
		}
		
		// 길이가 2인 수
		for(int i = 1; i < N; i++) {
			if(nums[i] == nums[i+1]) {
				dp[i][i+1] = 1;
			}
		}
		
		// 길이가 3이상인 수
		for(int i = 2; i < N; i++) {
			for(int j = 1; j <= N-i; j++) {
				if(nums[j] == nums[j+i] && dp[j+1][j+i-1] == 1) {
					dp[j][j+i] = 1;
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			bw.write(dp[start][end] + "\n");
		}
		
		bw.flush();
		br.close();
	}
}

