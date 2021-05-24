package BOJ_11055_가장큰증가부분수열;

import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] dp = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			dp[i] = nums[i];
			
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], nums[i]+dp[j]);
				}
			}
		}
		
		Arrays.sort(dp);
		
		System.out.println(dp[N-1]);
		
		br.close();
	}
}