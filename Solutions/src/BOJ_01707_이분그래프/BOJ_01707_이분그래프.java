package BOJ_01707_이분그래프;

import java.util.*;

public class BOJ_01707_이분그래프 {
	
	static LinkedList<Integer> adj[];
	static boolean[] v, group;
	static boolean result;
	static int V, E;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();

		for(int tc = 0; tc < K; tc++) {
			V = sc.nextInt();
			E = sc.nextInt();
			
			adj = new LinkedList[V+1];
			v = new boolean[V+1];
			group = new boolean[V+1];
			result = false;
			
			for(int i = 1; i <= V; i++) {
				adj[i] = new LinkedList<Integer>();
			}
			
			for(int i = 0; i < E; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();	
				
				adj[x].add(y);
				adj[y].add(x);
			}
			
			for(int i = 1; i <= V; i++) {
				if(!v[i]) {
					v[i] = true;
					dfs(i, false);
				}
			}
			
			if(result) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
			
		}
		
		
		sc.close();
	}
	
	private static void dfs(int node, boolean flag) {
		group[node] = flag;
		
		for(int i : adj[node]) {
			if(group[node] == group[i] && v[i]) {
				result = true;
			}
			
			if(!v[i]) {
				v[i] = true;
				dfs(i, !flag);
			}
		}
	}
}

