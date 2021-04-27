package BOJ_01774_우주신과의교감;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node {
		double x, y;

		public Node(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int x, y;
		double weight;
		
		public Edge(int x, int y, double weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return Double.compare(this.weight, e.weight);
		}
	}
	
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	static Node[] god;
	static int[] rank, p;
	static int N, M;
	static double min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		god = new Node[N+1];
		rank = new int[N+1];
		p = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			double X = Double.parseDouble(st.nextToken());
			double Y = Double.parseDouble(st.nextToken());
			
			god[i] = new Node(X, Y);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 1; i <= N; i++) {
			Node cur = god[i];
			
			for(int j = i+1; j <= N; j++) {
				Node next = god[j];
				
				double dis = Math.sqrt((cur.x - next.x)*(cur.x - next.x) + (cur.y - next.y)*(cur.y - next.y));
				
				pq.offer(new Edge(i, j, dis));
			}
		}
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			int x = find(cur.x);
			int y = find(cur.y);
			
			if(x == y) {
				continue;
			}
			
			union(x, y);
			
			min += cur.weight;
		}
		
		System.out.println(String.format("%.2f", min));
		
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

