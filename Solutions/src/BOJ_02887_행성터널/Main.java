package BOJ_02887_행성터널;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node {
		int idx, x, y, z;

		public Node(int idx, int x, int y, int z) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static Node[] planet;
	static int[] rank, p;
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	static int N, res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		planet = new Node[N];
		p = new int[N];
		rank = new int[N];
		
		for(int i = 0; i < N; i++) {
			p[i] = i;
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			planet[i] = new Node(i, x, y, z);
		}
		
		Arrays.sort(planet, (o1, o2) -> o1.x - o2.x);
		for(int i = 0; i < N-1; i++) {
			int dis = Math.abs(planet[i].x - planet[i+1].x);
			
			System.out.println("x: " + planet[i].idx + " " + i);
			pq.offer(new Edge(planet[i].idx, planet[i+1].idx, dis));
		}
		
		Arrays.sort(planet, (o1, o2) -> o1.y - o2.y);
		for(int i = 0; i < N-1; i++) {
			int dis = Math.abs(planet[i].y - planet[i+1].y);
			
			System.out.println("y: " + planet[i].idx + " " + i);
			pq.offer(new Edge(planet[i].idx, planet[i+1].idx, dis));
		}

		Arrays.sort(planet, (o1, o2) -> o1.z - o2.z);
		for(int i = 0; i < N-1; i++) {
			int dis = Math.abs(planet[i].z - planet[i+1].z);
			
			System.out.println("z: " + planet[i].idx + " " + i);
			pq.offer(new Edge(planet[i].idx, planet[i+1].idx, dis));
		}
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			
			
			int a = find(e.from);
			int b = find(e.to);
			
			if(a == b) {
				continue;
			}
			
			union(e.from, e.to);
			
			res += e.weight;
		}
		
		System.out.println(res);
		
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

