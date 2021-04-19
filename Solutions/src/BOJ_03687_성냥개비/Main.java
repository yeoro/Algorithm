package BOJ_03687_성냥개비;

import java.io.*;
import java.util.*;

class Main {
	
	static long[] needs;
	static int n;
	static long min;
	static String max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());

		needs = new long[101];
		Arrays.fill(needs, Long.MAX_VALUE);
		
		needs[2] = 1;
		needs[3] = 7;
		needs[4] = 4;
		needs[5] = 2;
		needs[6] = 6;
		needs[7] = 8;
		needs[8] = 10;

		makeMin();
		
		for(int tc = 0; tc < TC; tc++) {
			n = Integer.parseInt(br.readLine());
			
			min = needs[n];
			max = makeMax();
			
			System.out.println(min + " " + max);
		}
		
		br.close();
		bw.flush();
	}
	
	private static void makeMin() {
		for(int i = 9; i <= 100; i++) {
			for(int j = 2; j <= 7; j++) {
				StringBuilder sb = new StringBuilder();
				
				sb.append(needs[i-j]);
				
				if(j == 6) {
					sb.append(0);
				} else {
					sb.append(needs[j]);
				}
				
				needs[i] = Math.min(needs[i], Long.parseLong(sb.toString()));
			}
		}
	}
	
	private static String makeMax() {
		StringBuilder sb = new StringBuilder();
		
		if(n % 2 == 0) {
			for(int i = 0; i < n/2; i++) {
				sb.append(1);
			}
		} else {
			sb.append(7);
			
			for(int i = 0; i < (n-3)/2; i++) {
				sb.append(1);
			}
		}
		
		return sb.toString();
	}
}

