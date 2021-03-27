package BOJ_02693_N번째큰수;

import java.io.*;
import java.util.*;

public class BOJ_02693_N번째큰수 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		int[] arr;
		int N = 3;
		
		for(int tc = 0; tc < TC; tc++) {
			arr = new int[10];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			bw.write(arr[arr.length - N] + "\n");
		}
		
		br.close();
		bw.flush();
	}
}

