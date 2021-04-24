package BOJ_01058_친구;

import java.io.*;
import java.util.*;

class Main {
	
	static int[][] adj;
	static int N, INF = 1000001, max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		adj = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			
			for(int j = 0; j < N; j++) {
				if(input.charAt(j) == 'Y') {
					adj[i][j] = 1;
				} else {
					adj[i][j] = INF;
				}
				
				if(i == j) {
					adj[i][j] = 0;
				}
			}
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(adj[i][j] > adj[i][k] + adj[k][j]) {
						adj[i][j] = adj[i][k] + adj[k][j];
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < N; j++) {
				if(i != j && adj[i][j] <= 2) {
					sum++;
				}
			}
			max = Math.max(sum, max);
		}
		
		System.out.println(max);
		br.close();
	}
}

 