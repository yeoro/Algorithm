package BOJ_02458_Å°¼ø¼­;

import java.io.*;
import java.util.*;

class Main {
	
	static int[][] adj;
	static int N, M, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j) {
					adj[i][j] = 0;
				} else {
					adj[i][j] = 1000001;
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a][b] = -1;
			adj[b][a] = 1;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(adj[i][k] == -1 && adj[k][j] == -1) {
						adj[i][j] = -1;
						adj[j][i] = 1;
					}
					
					if(adj[i][k] == 1 && adj[k][j] == 1) {
						adj[i][j] = 1;
						adj[j][i] = -1;
					}
				}
			}
		}
		
		loop: for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i != j && adj[i][j] == 1000001) {
					continue loop;
				}
			}
			cnt++;
		}
		
		bw.write(cnt + "\n");
	
		bw.flush();
		br.close();
	}
}

