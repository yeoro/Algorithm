package BOJ_01260_DFS와BFS;

import java.util.*;

public class BOJ_01260_DFS와BFS {
	
	static int[][] map;
	static boolean[] v;
	static int N, M, V;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		map = new int[N+1][N+1];
		
		for(int i = 0; i < M; i++) { // 간선 연결
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			map[x][y] = map[y][x] = 1;
		}
		
		v = new boolean[N+1];
		dfs(V);
		
		System.out.println();
		
		v = new boolean[N+1];
		bfs(V);
		
		sc.close();
	}
	
	private static void dfs(int start) {
		v[start] = true;
		System.out.print(start + " ");
		
		for(int i = 1; i <= N; i++) {
			if(map[start][i] == 1 && v[i] == false) {
				v[i] = true;
				dfs(i);
			}
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		v[start] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node + " ");
			
			for(int i = 1; i <= N; i++) {
				if(map[node][i] == 1 && v[i] == false) {
					v[i] = true;
					q.add(i);
				}
			}
		}
		
		
	}
}

