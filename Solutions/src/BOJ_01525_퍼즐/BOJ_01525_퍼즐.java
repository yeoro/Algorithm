package BOJ_01525_∆€¡Ò;

import java.io.*;
import java.util.*;

public class BOJ_01525_∆€¡Ò {
	
	static int[] dx = {-3, 3, -1, 1};
	static int min = Integer.MAX_VALUE;
	static Queue<String> q = new LinkedList<String>();
	static HashMap<String, Integer> hm = new HashMap<String, Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		for(int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= 3; j++) {
				sb.append(st.nextToken());
			}
		}
		
		hm.put(sb.toString(), 0);
		q.add(sb.toString());
		
		bfs();

		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
		
		br.close();
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			String cur = q.poll();
			int zero = cur.indexOf("0");
			
			if(cur.equals("123456780")) {
				min = Math.min(min, hm.get(cur));
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = zero + dx[i];
				
				if(isIn(nx)) {
					if(zero != 0 && ((i == 3 && nx % 3 == 0) || (i == 2 && zero % 3 == 0))) {
						continue;
					}
					
					char cTemp = cur.charAt(nx);
					String sTemp = cur
							.replace(cur.charAt(zero), '9')
							.replace(cur.charAt(nx), '0');
					sTemp = sTemp.replace(sTemp.charAt(sTemp.indexOf("9")), cTemp);
					
					if(!hm.containsKey(sTemp)) {
						hm.put(sTemp, hm.get(cur)+1);
						q.add(sTemp);
					}
				}
			}
		}
	}
	
	private static boolean isIn(int x) {
		return x >= 0 && x < 9;
	}
}