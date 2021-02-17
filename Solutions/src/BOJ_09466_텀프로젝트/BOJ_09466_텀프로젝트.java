package BOJ_09466_텀프로젝트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ_09466_텀프로젝트 {
	
	static LinkedList<Integer> adj[];
	static boolean[] v;
	static int n, cnt;
	
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
			cnt = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int idx = 1;
			while(st.hasMoreTokens()) {
				adj[idx] = new LinkedList<Integer>();
				adj[idx].add(Integer.parseInt(st.nextToken()));
				idx++;
			}

			for(int i = 1; i <= n; i++) {
				if(!v[i]) {
					v[i] = true;
					dfs(i, i, 1);
				}
			}
			
			bw.write((n-cnt) + "\n");
		}
		
		br.close();
		bw.flush();
	}
	
	private static void dfs(int node, int start, int depth) {
		ListIterator<Integer> it = adj[node].listIterator();
		
		while(it.hasNext()) {
			int i = it.next();
			if(i == start) {
//				System.out.println("다음: " + i + " 시작점: " + start + " 선택: " + depth); 
//				System.out.println(Arrays.toString(v));
				cnt += depth;
			}

			if(!v[i]) {
				v[i] = true;
				
//				System.out.println("현재: " + node + " 다음: " + i);
				
				dfs(i, start, depth+1);
				v[i] = false;
			}
		}
	}
}

