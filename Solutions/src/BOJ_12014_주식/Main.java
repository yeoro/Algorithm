package BOJ_12014_аж╫д;

import java.io.*;
import java.util.*;

class Main {
	
	static int[] stock, lis;
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			stock = new int[N];
			lis = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				stock[i] = Integer.parseInt(st.nextToken());
			}
			
			int lisIdx = 0;
			lis[0] = stock[0];
			
			for(int i = 1; i < N; i++) {
				if(stock[i] > lis[lisIdx]) {
					lis[lisIdx+1] = stock[i];
					lisIdx++;
				} else {
					int sIdx = -(Arrays.binarySearch(lis, 0, lisIdx, stock[i])) - 1;
					
					if(sIdx < 0) {
						continue;
					}
					
					lis[sIdx] = stock[i];
				}
			}
			
			System.out.println("Case #" + t);
			
			if(lisIdx+1 >= K) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
		
		br.close();
	}
}

