package BOJ_11404_플로이드;

import java.io.*;
import java.util.*;

public class BOJ_11404_플로이드 {
	
	static int[][] adj;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		adj = new int[n][n];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if(adj[a-1][b-1] != 0) {
				adj[a-1][b-1] = Math.min(adj[a-1][b-1], c);
			} else {
				adj[a-1][b-1] = c;
			}
		}
		
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(isAdj(i, k) && isAdj(k, j) && isAnotherNode(i, j, k)) {
						if(adj[i][j] != 0) {
							adj[i][j] = Math.min(adj[i][k]+adj[k][j], adj[i][j]);
						} else if (adj[i][j] == 0){
							adj[i][j] = adj[i][k] + adj[k][j];
						}
					}
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
		
		br.close();
		bw.flush();
	}
	
	private static boolean isAdj(int x, int y) {
		return adj[x][y] > 0;
	}
	
	private static boolean isAnotherNode(int x, int y, int z) {
		return x != y && y != z && x != z;
	}
}

