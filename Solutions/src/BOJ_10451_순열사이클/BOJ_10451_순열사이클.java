package BOJ_10451_순열사이클;

import java.io.*;
import java.util.*;

public class BOJ_10451_순열사이클 {
	
	static LinkedList<Integer> adj[];
	static boolean[] v;
	static int N, result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			result = 0;
			adj = new LinkedList[N+1];
			v = new boolean[N+1];
			for(int i = 1; i <= N; i++) {
				adj[i] = new LinkedList<Integer>();
			}
			
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int idx = 1;
			while(st.hasMoreTokens()) {
				adj[idx].add(Integer.parseInt(st.nextToken()));
				idx++;
			}
			
			for(int i = 1; i <= N; i++) {
				if(!v[i]) {
					v[i] = true;
					dfs(i);
					result++;
				}
			}

			bw.write(result + "\n");
		}
		
		
		br.close();
		bw.flush();
	}
	
	private static void dfs(int node) {
		for(int i : adj[node]) {
			if(!v[i]) {
				v[i] = true;
				dfs(i);
			}
		}
	}
}

