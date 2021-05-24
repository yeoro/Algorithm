package BOJ_02565_ภüฑ๊มู;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node implements Comparable<Node>{
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.x, o.x);
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
	}
	static Node[] nums, dp;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		nums = new Node[N];
		dp = new Node[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			nums[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(nums);
		
		dp[0] = nums[0];
		int dpIdx = 0;
		
		for(int nIdx = 1; nIdx < N; nIdx++) {
			if(dp[dpIdx].x < nums[nIdx].x && dp[dpIdx].y < nums[nIdx].y) {
				dp[dpIdx+1] = nums[nIdx];
				dpIdx++;
			} else {
				int idx = binarySearch(0, dpIdx, nums[nIdx]);
				dp[idx] = nums[nIdx];
			}
		}
		
		System.out.println(N-(dpIdx+1));
		br.close();
	}
	
	private static int binarySearch(int left, int right, Node target) {
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(dp[mid].x < target.x && dp[mid].y < target.y) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		return right;
	}
}

