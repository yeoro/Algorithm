package BOJ_01967_트리의지름;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node implements Comparable<Node> {
		int to, v;

		public Node(int to, int v) {
			this.to = to;
			this.v = v;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(o.v, this.v);
		}

		
	}
	static ArrayList<Node>[] adj;
	static int[] dist;
	static boolean[] v;
	static int n, max = Integer.MIN_VALUE, maxIdx;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[n+1];
		
		for(int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<Main.Node>();
		}
		
		
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj[a].add(new Node(b, c));
			adj[b].add(new Node(a, c));
		}

		v = new boolean[n+1];
		dist = new int[n+1];
		solve(1);
		
		for(int i = 1; i <= n; i++) {
			if(max < dist[i]) {
				max = dist[i];
				maxIdx = i;
			}
		}
		
		v = new boolean[n+1];
		dist = new int[n+1];
		max = Integer.MIN_VALUE;
		solve(maxIdx);
		
		for(int i = 1; i <= n; i++) {
			max = Math.max(max, dist[i]);
		}
		
		System.out.println(max);
		
		br.close();
	}
	
	private static void solve(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Main.Node>();
		pq.offer(new Node(start, 0));
		v[start] = true;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for(Node next : adj[cur.to]) {
				if(!v[next.to]) {
					v[next.to] = true;
					dist[next.to] = cur.v + next.v;
					pq.offer(new Node(next.to, next.v + cur.v));
				}
			}
		}
		
	}
}

