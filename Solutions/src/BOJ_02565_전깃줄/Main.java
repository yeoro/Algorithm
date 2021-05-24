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
	static Node[] nums;
	static int[] dp;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		nums = new Node[N];
		dp = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			nums[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(nums);
		
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			
			for(int j = 0; j < N; j++) {
				if(nums[j].x < nums[i].x && nums[j].y < nums[i].y) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		Arrays.sort(dp);
		
		System.out.println(N - dp[N-1]);
		
		br.close();
	}
}

