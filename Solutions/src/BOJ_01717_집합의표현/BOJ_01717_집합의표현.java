package BOJ_01717_집합의표현;

import java.io.*;
import java.util.*;

public class BOJ_01717_집합의표현 {
	
	static int[] set, rank;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		set = new int[n+1];
		rank = new int[n+1];
		
		for(int i = 0; i <= n; i++) {
			set[i] = i;
			rank[i] = 0;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int v = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			switch(v) {
			case 0:
				union(a, b);
				
				break;
			case 1:
				if(find(a) == find(b)) {
					bw.write("YES\n");
				} else {
					bw.write("NO\n");
				}
				
				break;
			}
		}
		
		br.close();
		bw.flush();
	}
	
	private static void union(int a, int b) {
		int ar = find(a);
		int br = find(b);
		
		if(ar == br) {
			return;
		}
		
		if(rank[ar] < rank[br]) {
			set[ar] = br;
		} else {
			set[br] = ar;
		}
		
		if(rank[ar] == rank[br]) {
			rank[ar]++;
		}
	}
	
	private static int find(int a) {
		if(set[a] == a) {
			return a;
		}
		
		return set[a] = find(set[a]);
	}
}

