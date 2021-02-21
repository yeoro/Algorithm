package BOJ_02606_바이러스;

import java.io.*;
import java.util.*;

public class BOJ_02606_바이러스 {
	
	static LinkedList<Integer> adj[];
	static boolean[] v;
	static int N, E, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		adj = new LinkedList[N+1];
		v = new boolean[N+1];
		
		for(int i = 1; i <= N; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			adj[x].add(y);
			adj[y].add(x);
		}
		
		v[1] = true;
		dfs(1);
		
		bw.write(cnt + "\n");
		
		br.close();
		bw.flush();
	}
	
	private static void dfs(int node) {
		for(int i : adj[node]) {
			if(!v[i]) {
				v[i] = true;
				cnt++;
				dfs(i);
			}
		}
	}
}

