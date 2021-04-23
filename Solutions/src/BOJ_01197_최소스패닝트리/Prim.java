package BOJ_01197_최소스패닝트리;

import java.io.*;
import java.util.*;

class Prim {

	static LinkedList<Node2>[] adj;
	static PriorityQueue<Node2> pq;
	static boolean[] v;
	static int V, E, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adj = new LinkedList[V+1];
		pq = new PriorityQueue<Node2>();
		v = new boolean[V+1];

		// 인접리스트 초기화
		for(int i = 1; i <= V; i++) {
			adj[i] = new LinkedList<Node2>();
		}
		
		// 간선 정보 입력
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			adj[A].add(new Node2(B, C));
			adj[B].add(new Node2(A, C));
		}
		
		v[1] = true;
		for(Node2 n : adj[1]) {
			pq.offer(n);
		}
		
		while(!pq.isEmpty()) {
			Node2 cur = pq.poll();
			
			if(v[cur.to]) {
				continue;
			}
			
			v[cur.to] = true;
			cnt += cur.weight;

			for(Node2 n : adj[cur.to]) {
				if(!v[n.to]) {
					pq.offer(n);
				}
			}
		}
		
		bw.write(cnt + "\n");

		br.close();
		bw.flush();
	}
}

class Node2 implements Comparable<Node2>{
	int to, weight;

	public Node2(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node2 o1) {
		return Integer.compare(this.weight, o1.weight);
	}
}
