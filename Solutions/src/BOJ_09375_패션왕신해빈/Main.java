package BOJ_09375_ÆÐ¼Ç¿Õ½ÅÇØºó;

import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			
			int cnt = 1;
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				
				String type = st.nextToken();
				
				hm.put(type, hm.getOrDefault(type, 1)+1);
			}
			
			for(Map.Entry<String, Integer> e : hm.entrySet()) {
				cnt *= e.getValue();
			}
			
			System.out.println(cnt-1);
		}
		
		br.close();
	}
}