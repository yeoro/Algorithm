package BOJ_12865_Æò¹üÇÑ¹è³¶;

import java.io.*;
import java.util.*;

class Main {
	
	static int[][] dp;
	static int[] w, v;
	static int N, K, max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][K+1];
		w = new int[N+1];
		v = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			w[i] = W;
			v[i] = V;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = K; j >= 1; j--) {
				if(w[i] <= j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		bw.write(dp[N][K] + "\n");
		
		br.close();
		bw.flush();
	}
}

