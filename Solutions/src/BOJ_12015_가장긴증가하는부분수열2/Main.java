package BOJ_12015_가장긴증가하는부분수열2;

import java.io.*;
import java.util.*;

class Main {
	
	static int[] dp, nums;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N];
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = nums[0];
		int dIdx = 0;
		
		for(int nIdx = 1; nIdx < N; nIdx++) {
			if(dp[dIdx] < nums[nIdx]) {
				dp[dIdx+1] = nums[nIdx];
				dIdx++;
			} else {
				int idx = binarySearch(0, dIdx, nums[nIdx]);
				dp[idx] = nums[nIdx];
			}
		}
		
		System.out.println(dIdx+1);
		
		br.close();
	}
	
	private static int binarySearch(int left, int right, int target) {
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(dp[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		return right;
	}
}

