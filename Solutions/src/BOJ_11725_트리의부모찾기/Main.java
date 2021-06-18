package BOJ_11725_트리의부모찾기;

import java.io.*;
import java.util.*;

class Main {
	
	static ArrayList<Integer>[] adj;
	static boolean[] v;
	static int[] p, r;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N+1];
		v = new boolean[N+1];
		p = new int[N+1];
		r = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		v[1] = true;
		solve(1);
		
		for(int i = 2; i <= N; i++) {
			System.out.println(p[i]);
		}
		
		br.close();
	}
	
	private static void solve(int node) {
		for(int next : adj[node]) {
			if(!v[next]) {
				v[next] = true;
				p[next] = node;
				solve(next);
			}
		}
	}
	
}

