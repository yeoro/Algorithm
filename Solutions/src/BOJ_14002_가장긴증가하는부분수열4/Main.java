package BOJ_14002_가장긴증가하는부분수열4;

import java.io.*;
import java.util.*;

class Main {
	
	static ArrayList<Integer>[] list;
	static int[] dp, nums, pre;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N];
		pre = new int[N];
		nums = new int[N];
		
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			pre[i] = -1;
			
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i] && dp[i] < dp[j]+1) {
					dp[i] = dp[j]+1;
					pre[i] = j;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		int maxIdx = 0;
		
		for(int i = 0; i < N; i++) {
			if(max < dp[i]) {
				max = dp[i];
				maxIdx = i;
			}
		}
		System.out.println(max);
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while(maxIdx != -1) {
			stack.add(nums[maxIdx]);
			maxIdx = pre[maxIdx];
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

		br.close();
	}
}

