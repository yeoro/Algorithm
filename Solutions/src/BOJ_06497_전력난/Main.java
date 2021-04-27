package BOJ_06497_Àü·Â³­;

import java.io.*;
import java.util.*;

class Main {
	
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
	
	static Edge[] adj;
	static int[] rank, p;
	static int m, n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			if(m == 0 && n == 0) {
				break;
			}
			
			adj = new Edge[n];
			rank = new int[m];
			p = new int[m];
			
			int min = 0;
			int total = 0;
			
			for(int i = 0; i < m; i++) {
				p[i] = i;
			}
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				
				adj[i] = new Edge(x, y, z);
				
				total += z;
			}
			
			Arrays.sort(adj);
			
			for(Edge e : adj) {
				int x = find(e.from);
				int y = find(e.to);
				
				if(x == y) {
					continue;
				}
				
				union(x, y);
				
				min += e.weight;
			}
			
			bw.write((total-min) + "\n");
		}
		
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

