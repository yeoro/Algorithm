package BOJ_01005_ACMCraft;

import java.io.*;
import java.util.*;

class Main {
	
	static ArrayList<Integer>[] adj;
	static Queue<Integer> q;
	static int[] time, dp, indegree;
	static int N, K, W;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[N+1];
			time = new int[N+1];
			indegree = new int[N+1];
			dp = new int[N+1];
			q = new LinkedList<Integer>();
			
			Arrays.fill(dp, Integer.MIN_VALUE);
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<Integer>();
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				adj[X].add(Y);
				indegree[Y]++;
			}
			
			W = Integer.parseInt(br.readLine());
			
			for(int i = 1; i <= N; i++) {
				if(indegree[i] == 0) {
					q.add(i);
					dp[i] = time[i];
				}
			}
			
			solve();
			
			System.out.println(dp[W]);
		}
		
		br.close();
	}
	
	private static void solve() {
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : adj[cur]) {
				indegree[next]--;
				dp[next] = Math.max(dp[next], time[next] + dp[cur]);
				
				if(indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}