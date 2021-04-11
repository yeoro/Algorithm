package BOJ_01717_집합의표현;

import java.io.*;
import java.util.*;

public class BOJ_01717_집합의표현 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer>[] list = new LinkedList[n+1];
		
		for(int i = 0; i <= n; i++) {
			list[i] = new LinkedList<Integer>();
			list[i].add(i);
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int v = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			switch(v) {
			case 0:
				for(int num : list[a]) {
					if(!list[b].contains(num)) {
						list[b].add(num);
					}
				}
				
				for(int num : list[b]) {
					if(!list[a].contains(num)) {
						list[a].add(num);
					}
				}
				
				for(int j = 0; j <= n; j++) {
					for(int num : list[j]) {
						System.out.print(j + ": " + num + " ");
					}
					System.out.println();
				}
				
				break;
			case 1:
				if(list[a].contains(b) && list[b].contains(a)) {
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
}

