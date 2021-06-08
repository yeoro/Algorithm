package BOJ_12869_¹ÂÅ»¸®½ºÅ©;

import java.io.*;
import java.util.*;

class Main {
	
	static int[][][] dp;
	static int[] scv;
	static int N, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		scv = new int[3];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[scv[0]+1][scv[1]+1][scv[2]+1];
		
		attack(scv[0], scv[1], scv[2], 0);
		
		System.out.println(min);
		
		br.close();
	}
	
	private static void attack(int a, int b, int c, int depth) {
		if(a <= 0 && b <= 0 && c <= 0) {
			min = Math.min(min, depth);
			return;
		}
		
		if(a <= 0) a = 0;
		if(b <= 0) b = 0;
		if(c <= 0) c = 0;
		
		if(dp[a][b][c] <= depth && dp[a][b][c] != 0) {
			return;
		}
		
		dp[a][b][c] = depth;
		
		attack(a-9, b-3, c-1, depth+1);
		attack(a-9, b-1, c-3, depth+1);
		attack(a-3, b-9, c-1, depth+1);
		attack(a-3, b-1, c-9, depth+1);
		attack(a-1, b-9, c-3, depth+1);
		attack(a-1, b-3, c-9, depth+1);
	}
}