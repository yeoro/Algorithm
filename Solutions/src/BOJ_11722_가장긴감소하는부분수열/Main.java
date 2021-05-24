package BOJ_11722_가장긴감소하는부분수열;

import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N];
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = N-1; i >= 0; i--) {
			dp[i] = 1;
			
			for(int j = N-1; j > i; j--) {
				if(nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		Arrays.sort(dp);
		
		System.out.println(dp[N-1]);
		
		br.close();
	}
}

