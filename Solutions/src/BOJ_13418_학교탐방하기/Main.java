package BOJ_13418_학교탐방하기;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node implements Comparable<Node>{
		int to, next, load;

		public Node(int to, int next, int load) {
			this.to = to;
			this.next = next;
			this.load = load;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(o.load, this.load);
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", next=" + next + ", load=" + load + "]";
		}
		
		
		
	}
	static Node[] adj;
	static boolean[] v;
	static int[] p, r;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new Node[M+1];

		for(int i = 0; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			adj[i] = new Node(A, B, C);
		}
		
		Arrays.sort(adj);
		long min = mst();
		
		Arrays.sort(adj, (o1, o2) -> o1.load - o2.load);
		long max = mst();
		
		System.out.println((max*max) - (min*min));
		
		
		br.close();
	}
	
	private static long mst() {
		p = new int[N+1];
		r = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			p[i] = i;
		}
		
		long cnt = 0;
		
		for(int i = 0; i < M; i++) {
			int a = find(adj[i].to);
			int b = find(adj[i].next);
			
			if(a == b) {
				continue;
			}
			
			union(a, b);
			
			if(adj[i].load == 0) {
				cnt++;
			}
		}
		
		return cnt;
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
		
		if(r[xr] < r[yr]) {
			p[xr] = yr;
		} else {
			p[yr] = xr;
		}
		
		if(r[xr] == r[yr]) {
			r[xr]++;
		}
	}
}

