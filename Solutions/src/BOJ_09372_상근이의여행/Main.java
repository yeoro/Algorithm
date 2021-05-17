package BOJ_09372_상근이의여행;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node {
		int from, to;

		public Node(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
	static Node[] adj;
	static int[] p, r;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
		
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			p = new int[N+1];
			r = new int[N+1];
			adj = new Node[M];
			int cnt = 0;
			
			for(int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				adj[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			for(Node n : adj) {
				int a = find(n.from);
				int b = find(n.to);
				
				if(a == b) {
					continue;
				}
				
				cnt++;
				union(a, b);
			}
			
			System.out.println(cnt);
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

