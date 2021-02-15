package BOJ_11724_연결요소의개수;

import java.util.*;

public class BOJ_11724_연결요소의개수 {
	
	static int[][] adj;
	static boolean[] v;
	static int N, M, cnt, result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		adj = new int[N+1][N+1];
		v = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			adj[x][y] = adj[y][x] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			cnt = 0;
			if(!v[i]) {
				v[i] = true;
				dfs(i);
				result++;
			}
		}
		
		System.out.println(result);
		
		sc.close();
	}
	
	private static void dfs(int node) {
		for(int i = 1; i <= N; i++) {
			if(adj[node][i] == 1 && !v[i]) {
				v[i] = true;
				cnt++;
				dfs(i);
			}
		}
	}
}

