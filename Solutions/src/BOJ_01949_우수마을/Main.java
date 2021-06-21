package BOJ_01949_우수마을;

import java.io.*;
import java.util.*;

class Main {
	
	static ArrayList<Integer>[] adj;
	static int[][] dp;
	static int[] population;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		population = new int[N+1];
		adj = new ArrayList[N+1];
		dp = new int[N+1][2];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			adj[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adj[A].add(B);
			adj[B].add(A);
		}
		
		solve(1, 0);
		
		System.out.println(Math.max(dp[1][0], dp[1][1]));
		
		br.close();
	}
	
	private static void solve(int cur, int pre) {
		for(int next : adj[cur]) {
			if(next != pre) {
				solve(next, cur);
				
				dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
				dp[cur][1] += dp[next][0];
			}
		}
		
		dp[cur][1] += population[cur];
	}
}