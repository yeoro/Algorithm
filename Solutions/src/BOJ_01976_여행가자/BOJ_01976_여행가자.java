package BOJ_01976_여행가자;

import java.io.*;
import java.util.*;

public class BOJ_01976_여행가자 {
	
	static int[] course;
	static int[] city;
	static int[] rank;
	static int N, M;
	static boolean check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		city = new int[N+1];
		rank = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			city[i] = i;
			rank[i] = 0;
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 1; j <= N; j++) {
				int connect = Integer.parseInt(st.nextToken());
				
				if(connect == 1) {
					union(i, j);
				}
			}
		}
		
		course = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < M; i++) {
			course[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M-1; i++) {
			if(city[course[i]] != city[course[i+1]]) {
				check = true;
				break;
			}
		}
		
		if(check) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
		
		br.close();
	}	
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) {
			return;
		}
		
		if(rank[x] < rank[y]) {
			city[x] = y;
		} else {
			city[y] = x;
		}
		
		if(rank[x] == rank[y]) {
			rank[x]++;
		}
	}
	
	private static int find(int x) {
		if(city[x] == x) {
			return x;
		}
		
		return city[x] = find(city[x]);
	}
}

