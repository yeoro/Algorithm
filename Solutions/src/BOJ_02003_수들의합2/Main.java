package BOJ_02003_수들의합2;

import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0, sum = 0, cnt = 0;
		while(end <= N) {
			if(sum == M) {
				cnt++;
			}
			
			if(sum < M) {
				sum += nums[end++];
			} else {
				sum -= nums[start++];
			}
		}
		
		System.out.println(cnt);
		br.close();
	}
}

