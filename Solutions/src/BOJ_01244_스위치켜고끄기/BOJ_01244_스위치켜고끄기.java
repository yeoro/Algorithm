package BOJ_01244_스위치켜고끄기;

import java.io.*;
import java.util.*;


public class BOJ_01244_스위치켜고끄기 {
	
	static int[] arr;
	static int N, S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		S = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			switch(gender) {
			case 1: // 남학생
				for(int j = num; j <= N; j++) {
					if(j % num == 0) {
						arr[j] ^= 1;
					}
				}
				
				break;
			case 2: // 여학생
				int idx = 1;
				
				while(true) {
					int right = num+idx;
					int left = num-idx;
					
					if(right <= N && left > 0) {
						if(arr[right] == arr[left]) {
							idx++;
							continue;
						}
					}
					
					idx--;
					
					for(int j = num-idx; j <= num+idx; j++) {
						arr[j] ^= 1;
					}
					
					break;
				}
				
				break;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(arr[i] + " ");
			if(i % 20 == 0) {
				System.out.println();
			}
		}
		
		br.close();
	}
}

