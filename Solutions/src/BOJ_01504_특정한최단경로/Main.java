package BOJ_01504_특정한최단경로;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node implements Comparable<Node>{
		int idx, dis;

		public Node(int x, int dis) {
			this.idx = x;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.dis, o.dis);
		}
	}
	static ArrayList<Node>[] adj;
	static int[] dis;
	static int N, E, v1, v2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
	
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Main.Node>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj[a].add(new Node(b, c));
			adj[b].add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		// 1 -> v1 -> v2 -> N
		int res1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
		
		// 1 -> v2 -> v1 -> N
		int res2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
		
		if(E == 0 || (res1 >= Integer.MAX_VALUE && res2 >= Integer.MAX_VALUE)) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(res1, res2));
		}
		
		br.close();
	}
	
	private static int dijkstra(int start, int end) {
		dis = new int[N+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<Main.Node>();
		pq.offer(new Node(start, 0));
		dis[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int to = cur.idx;
			
			for(Node n : adj[to]) {
				int next = n.idx;
				int nd = n.dis;
				
				if(dis[next] > dis[to] + nd) {
					dis[next] = dis[to] + nd;
					
					pq.offer(new Node(next, dis[next]));
				}
			}
		}
	
		return dis[end];
	}
}