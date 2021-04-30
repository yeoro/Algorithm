package BOJ_01316_그룹단어체커;

import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		HashMap<Character, Integer> hm;
		
		loop: for(int i = 0; i < N; i++) {
			String cur = br.readLine();
			
			hm = new HashMap<Character, Integer>();
			
			for(int j = 0, l = cur.length(); j < l; j++) {
				if(hm.containsKey(cur.charAt(j))) {
					if(j - hm.get(cur.charAt(j)) != 1) {
						continue loop;
					}
				}
				
				hm.put(cur.charAt(j), j);
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
		
		br.close();
	}
}

