package BOJ_02352_반도체설계;

import java.io.*;
import java.util.*;

class Main {
	
	static class Port {
		int idx, next;

		public Port(int idx, int next) {
			this.idx = idx;
			this.next = next;
		}
	}
	static Port[] dp, p;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		dp = new Port[n+1];
		p = new Port[n+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1; i <= n; i++) {
			p[i] = new Port(i, Integer.parseInt(st.nextToken()));
		}
		
		dp[1] = p[1];
		int dIdx = 1;
		
		for(int pIdx = 2; pIdx <= n; pIdx++) {
			if(dp[dIdx].idx < p[pIdx].idx && dp[dIdx].next < p[pIdx].next) {
				dp[dIdx+1] = p[pIdx];
				dIdx++;
			} else {
				int idx = binarySearch(1, dIdx, p[pIdx]);
				dp[idx] = p[pIdx];
			}
		}
		
		System.out.println(dIdx);
		
		br.close();
	}
	
	private static int binarySearch(int left, int right, Port target) {
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(dp[mid].idx < target.idx && dp[mid].next < target.next) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		return right;
	}
}

