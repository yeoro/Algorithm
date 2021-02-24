package BOJ_02644_ÃÌ¼ö°è»ê;

import java.io.*;
import java.util.*;

public class BOJ_02644_ÃÌ¼ö°è»ê {
	
	static int[][] adj;
	static int n, m, relation1, relation2, INF = 10000*100+1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		adj = new int[n+1][n+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		relation1 = Integer.parseInt(st.nextToken());
		relation2 = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i != j) {
					adj[i][j] = INF;
				}
			}
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			adj[x][y] = adj[y][x] = 1;
		}
		
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(i != j) {
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
					}
				}
			}
		}
		
		if(adj[relation1][relation2] != INF) {
			bw.write(adj[relation1][relation2] + "\n");
		} else {
			bw.write("-1\n");
		}
		
		br.close();
		bw.flush();
	}
}

