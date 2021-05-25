package BOJ_11053_가장긴증가하는부분수열;

import java.io.*;
import java.util.*;

class ArraysBinarySearchMethod {
	
	static int[] dp, nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		nums = new int[N];
		dp = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = nums[0];
		int dpIdx = 0;
		
		for(int numsIdx = 1; numsIdx < N; numsIdx++) {
			if(dp[dpIdx] < nums[numsIdx]) {	
				dp[dpIdx+1] = nums[numsIdx];
				dpIdx++;
			} else {
				int idx = -(Arrays.binarySearch(dp, 0, dpIdx, nums[numsIdx])) - 1;
				if(idx < 0) {
					continue;
				} 
				dp[idx] = nums[numsIdx];
			}
		}
		
		System.out.println(dpIdx+1);
		
		br.close();
	}
}

