package BOJ_14621_나만안되는연애;

import java.io.*;
import java.util.*;

class Main {
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		long weight;
		
		public Edge(int from, int to, long weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	static int[] p, rank;
	static String[] school;
	static int N, M, cnt;
	static long res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		school = new String[N+1];
		rank = new int[N+1];
		p = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1; i <= N; i++) {
			school[i] = st.nextToken();
			p[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			long d = Long.parseLong(st.nextToken());
			
			if(!school[u].equals(school[v])) {
				pq.offer(new Edge(u, v, d));
			}
		}
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			int a = find(cur.from);
			int b = find(cur.to);
			
			if(a == b) {
				continue;
			}
			
			union(a, b);
			
			cnt++;
			res += cur.weight;
		}
		
		if(cnt != N-1) {
			System.out.println(-1);
		} else {
			System.out.println(res);
		}
		
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

