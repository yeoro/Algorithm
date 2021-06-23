package BOJ_02252_줄세우기;

import java.io.*;
import java.util.*;

class Main {
	
	static ArrayList<Integer>[] adj;
	static Stack<Integer> stack = new Stack<Integer>();
	static Stack<Integer> ans = new Stack<Integer>();
	static boolean[] v;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		v = new boolean[N+1];
		
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adj[A].add(B);
		}
		
		for(int i = 1; i <= N; i++) {
			solve(i);
		}
		
		while(!ans.isEmpty()) {
			System.out.print(ans.pop() + " ");
		}
		
		br.close();
	}
	
	private static void solve(int node) {
		if(v[node]) {
			return;
		}
		
		v[node] = true;
		stack.push(node);
		
		for(int next : adj[node]) {
			solve(next);
		}
		
		ans.push(stack.pop());
	}
}

