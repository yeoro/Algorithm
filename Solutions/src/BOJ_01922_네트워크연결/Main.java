package BOJ_01922_네트워크연결;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node implements Comparable<Node>{
		int from, to, weight;

		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static Node[] adj;
	static int[] rank, p;
	static int N, M, min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adj = new Node[M];
		p = new int[N+1];
		rank = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj[i] = new Node(a, b, c);
		}
		
		Arrays.sort(adj);
		
		for(Node n : adj) {
			int a = find(n.from);
			int b = find(n.to);
			
			if(a == b) {
				continue;
			}
			
			union(a, b);
			
			min += n.weight;
		}
		
		System.out.println(min);
		
		br.close();
	}
	
	private static int find(int x) {
		if(x == p[x]) {
			return x;
		}
		
		return p[x] = find(p[x]);
	}
	
	private static void union(int x, int y) {
		int xr = find(x);
		int yr = find(y);
		
		if(xr == yr) {
			return;
		}
		
		if(rank[xr] < rank[yr]) {
			p[xr] = yr;
		} else {
			p[yr] = xr;
		}
		
		if(rank[xr] == rank[yr]) {
			rank[xr]++;
		}
	}
}

