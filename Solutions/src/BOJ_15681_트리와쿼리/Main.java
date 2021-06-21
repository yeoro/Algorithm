package BOJ_15681_Æ®¸®¿ÍÄõ¸®;

import java.io.*;
import java.util.*;

class Main {

	static ArrayList<Integer>[] adj;
	static int[] dp;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		dp = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			adj[U].add(V);
			adj[V].add(U);
		}
		
		solve(R, -1);
		
		for(int i = 0; i < Q; i++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
		
		
		br.close();
	}
	
	private static void solve(int cur, int parent) {
		for(int child : adj[cur]) {
			if(child != parent) {
				solve(child, cur);
				
				dp[cur] += dp[child];
			}
		}
		
		dp[cur] += 1;
	}
}