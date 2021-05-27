package BOJ_05567_°áÈ¥½Ä;

import java.io.*;
import java.util.*;

class Main {
	
	static ArrayList<Integer>[] adj;
	static boolean[] v;
	static int[] dis;
	static int n, m, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[n+1];
		v = new boolean[n+1];
		dis = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		solve(1);
		
		for(int i = 2; i <= n; i++) {
			if(dis[i] <= 2 && dis[i] > 0) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		br.close();
	}
	
	private static void solve(int idx) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(idx);
		dis[1] = 0;
		v[idx] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i : adj[cur]) {
				if(!v[i]) {
					v[i] = true;
					dis[i] = dis[cur] + 1;
					q.add(i);
				}
			}
		}
	}
}

