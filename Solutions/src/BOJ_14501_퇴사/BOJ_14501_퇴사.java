package BOJ_14501_Επ»η;

import java.io.*;
import java.util.*;

public class BOJ_14501_Επ»η {
	
	static int[] T, P;
	static boolean[] v;
	static int N, max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		T = new int[N];
		P = new int[N];
		v = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(-1, 0);
		
		System.out.println(max);
		
		br.close();
	}
	
	private static void solve(int cur, int p) {
		if(cur >= N) {
			return;
		}

		max = Math.max(max, p);
		
		for(int i = cur+1; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				solve(i + T[i] - 1, p + P[i]);
				v[i] = false;
			}
		}
	}
}

