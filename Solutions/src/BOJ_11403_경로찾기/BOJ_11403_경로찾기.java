package BOJ_11403_경로찾기;

import java.io.*;
import java.util.*;

public class BOJ_11403_경로찾기 {

	static int[][] adj;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		adj = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(adj[i][k] == 1 && adj[k][j] == 1) {
						adj[i][j] = 1;
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				bw.write(adj[i][j] + " ");
			}
			bw.write("\n");
		}
		
		br.close();
		bw.flush();
	}
}

