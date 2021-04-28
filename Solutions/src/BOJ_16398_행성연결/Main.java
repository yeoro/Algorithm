package BOJ_16398_행성연결;

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
	static int N;
	static long res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		rank = new int[N+1];
		p = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 1; j <= N; j++) {
				long weight = Long.parseLong(st.nextToken());
				
				if(i != j) {
					pq.offer(new Edge(i, j, weight));
				}
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
			
			res += cur.weight;
		}
		
		bw.write(res + "\n");
		
		bw.flush();
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

