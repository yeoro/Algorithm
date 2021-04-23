package BOJ_01197_최소스패닝트리;

import java.io.*;
import java.util.*;

class Main {
	
	static Node[] adj;
	static int[] p, rank;
	static int V, E, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		p = new int[V+1];
		rank = new int[V+1];
		adj = new Node[E];
		
		// 각 정점의 부모 초기화
		for(int i = 1; i <= V; i++) {
			p[i] = i;
		}
		
		// 간선 정보 입력
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			adj[i] = new Node(A, B, C);
		}
		
		// 가중치 오름차순으로 정렬
		Arrays.sort(adj);
		
		for(Node n : adj) {
			int a = find(n.from);
			int b = find(n.to);
			
			if(a == b) {
				continue;
			}
			
			union(a, b);
			
			cnt += n.weight;
		}
		
		bw.write(cnt + "\n");
		
		br.close();
		bw.flush();
	}
	
	private static int find(int a) {
		if(a == p[a]) {
			return a;
		}
		
		return p[a] = find(p[a]);
	}
	
	private static void union(int a, int b) {
		int ar = find(a);
		int br = find(b);
		
		if(ar == br) {
			return;
		}
		
		if(rank[ar] < rank[br]) {
			p[ar] = br;
		} else {
			p[br] = ar;
		}
		
		if(rank[ar] == rank[br]) {
			rank[ar]++;
		}
	}
}

class Node implements Comparable<Node>{
	int from, to, weight;

	public Node(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o1) {
		return Integer.compare(this.weight, o1.weight);
	}
	
	@Override
	public String toString() {
		return "from: " + from + " to: " + to + " weight: " + weight;
	}
}

