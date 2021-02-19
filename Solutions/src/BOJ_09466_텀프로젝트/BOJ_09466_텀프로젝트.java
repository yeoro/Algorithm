package BOJ_09466_텀프로젝트;

import java.io.*;
import java.util.*;

public class BOJ_09466_텀프로젝트 {
	
	static LinkedList<Integer> adj[];
	static ArrayList<Integer> check;
	static boolean[] v, cycle;
	static int n, cnt;
	static boolean isCycle;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			adj = new LinkedList[n+1];
			v = new boolean[n+1];
			cycle = new boolean[n+1];	
			cnt = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int idx = 1;
			while(st.hasMoreTokens()) {
				adj[idx] = new LinkedList<Integer>();
				adj[idx].add(Integer.parseInt(st.nextToken()));
				idx++;
			}

			for(int i = 1; i <= n; i++) {
				check = new ArrayList<Integer>();
				isCycle = false;
				if(!cycle[i]) {
					v[i] = true;
					check.add(i);
					dfs(i, i);
				}
				if(isCycle) {
					for(int c : check) {
						cycle[c] = true;
					}
				}
			}
			
			bw.write((n-cnt) + "\n");
		}
		
		br.close();
		bw.flush();
	}
	
	private static void dfs(int node, int start) {
		ListIterator<Integer> it = adj[node].listIterator();
		
		while(it.hasNext()) {
			int i = it.next();
			
			if(i == node) { // 자기 자신 선택
				cnt++;
				cycle[i] = true;
				v[i] = true;
				isCycle = true;
				return;
			}
			
			if(i == start) { // 다른 사람 선택
				cnt += check.size();
				isCycle = true;
				return;
			}

			if(!v[i]) {
				v[i] = true;
				check.add(i);
				dfs(i, start);
				if(!cycle[i]) {
					v[i] = false;
				}
			}
		}
	}
}

