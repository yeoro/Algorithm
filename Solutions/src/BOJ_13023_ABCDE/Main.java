package BOJ_13023_ABCDE;

import java.io.*;
import java.util.*;

class Main {
	
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static LinkedList<Integer>[] adj;
	static boolean[] v;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new LinkedList[N];
		
		for(int i = 0; i < N; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		for(int i = 0; i < N; i++) {
			v = new boolean[N];
			bfs(i);
		}
		
		br.close();
	}
	
	private static void bfs(int node) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(node);
		list.add(node);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i : adj[cur]) {
				if(!list.contains(i)) {
					list.add(i);
					q.offer(i);
					
					if(list.size() == 5) {
						for(int j : list) {
							System.out.print(j + " ");
						}
						System.out.println();
					}
				}
			}
		}
	}
}

