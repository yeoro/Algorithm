package BOJ_04386_별자리만들기;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node implements Comparable<Node> {
		double x, y, weight;

		public Node(double x, double y, double weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	
	static Node[] star;
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	static int[] rank, p;
	static int n;
	static double min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		star = new Node[n+1];
		rank = new int[n+1];
		p = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			p[i] = i;
		}
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			star[i] = new Node(x, y, 0);
		}
		
		// 모든 별끼리의 간선 정보 입력
		for(int i = 1; i <= n; i++) {
			Node cur = star[i];
			
			for(int j = i+1; j <= n; j++) {
				Node next = star[j];
				
				double dis = Math.sqrt((cur.x - next.x)*(cur.x - next.x) + (cur.y - next.y)*(cur.y - next.y));
				
				pq.offer(new Node(i, j, dis));
			}
		}
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			int a = find((int) cur.x);
			int b = find((int) cur.y);
			
			if(a == b) {
				continue;
			}
			
			union(a, b);
			
			min += cur.weight;
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

