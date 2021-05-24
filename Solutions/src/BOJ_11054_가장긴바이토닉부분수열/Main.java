package BOJ_11054_가장긴바이토닉부분수열;

import java.io.*;
import java.util.*;

class Main {
	
	static int[] og, reverse, nums, dp;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N];
		og = new int[N];
		reverse = new int[N];
		
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			og[i] = 1;
			
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					og[i] = Math.max(og[i], og[j]+1);
				}
			}
		}
		
		for(int i = N-1; i >= 0; i--) {
			reverse[i] = 1;
			
			for(int j = N-1; j > i; j--) {
				if(nums[j] < nums[i]) {
					reverse[i] = Math.max(reverse[i], reverse[j]+1);
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			dp[i] = og[i] + reverse[i] - 1;
		}
		
		Arrays.sort(dp);
		
		System.out.println(dp[N-1]);
		
		br.close();
	}
}

