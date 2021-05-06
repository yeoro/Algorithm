package BOJ_01806_ºÎºÐÇÕ;

import java.io.*;
import java.util.*;

class Main {
	
	static int[] nums;
	static int N, S;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0, sum = 0, min = Integer.MAX_VALUE;
		while(end <= N) {
			if(sum < S) {
				sum += nums[end++];
			} else {
				min = Math.min(min, end - start);
				sum -= nums[start++];
			}
		}
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
		
		br.close();
		
	}
}

