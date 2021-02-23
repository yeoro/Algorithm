package BOJ_11403_경로찾기;

import java.io.*;
import java.util.*;

public class BOJ_11403_경로찾기 {

	static int[][] result;
	static LinkedList<Integer> adj[];
	static boolean[] v;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		adj = new LinkedList[N];
		v = new boolean[N];
		result = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				int edge = Integer.parseInt(st.nextToken());
				
				if(edge == 1) {
					adj[i].add(j);
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			dfs(i, i);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		br.close();
		bw.flush();
	}
	
	private static void dfs(int node, int root) {
		for(int i : adj[node]) {
			if(result[node][i] == 0) {
				result[node][i] = 1;
			}
			
			if(result[root][i] == 0) {
				result[root][i] = 1;
			}
			
			dfs(i, root);
		}
	}
}

