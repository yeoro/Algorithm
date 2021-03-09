package BOJ_01039_교환;

import java.io.*;
import java.util.*;

public class BOJ_01039_교환 {
	
	static boolean[][] v;
	static int N, M, K, max = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.toString(N).length();
		K = Integer.parseInt(st.nextToken());
		
		v = new boolean[1000001][K+1];
		
		bfs();
		
		bw.write(max + "\n");
		
		br.close();
		bw.flush();
	}
	
	private static void bfs() {
		Queue<Number> q = new LinkedList<Number>();
		q.add(new Number(N, 0));
		v[N][0] = true;
		
		while(!q.isEmpty()) {
			Number n = q.poll();
			int num = n.n;
			int cnt = n.cnt;
			
			if(cnt == K) {
				max = Math.max(num, max);
				continue;
			}
			
			for(int i = 0; i < M; i++) {
				for(int j = i+1; j < M; j++) {
					int temp = swap(num, i, j);
					
					if(temp != -1 && !v[temp][cnt+1]) {
						v[temp][cnt+1] = true;
						q.add(new Number(temp, cnt+1));
					}
				}
			}
		}
	}
	
	private static int swap(int n, int i, int j) {
		StringBuffer sb = new StringBuffer(Integer.toString(n));
		
		char c1 = sb.charAt(i);
		char c2 = sb.charAt(j);
		
		sb.setCharAt(i, c2);
		sb.setCharAt(j, c1);
		
		if(sb.charAt(0) == '0') {
			return -1;
		}
		
		return Integer.parseInt(sb.toString());
	}
}

class Number {
	int n, cnt;

	public Number(int n, int cnt) {
		this.n = n;
		this.cnt = cnt;
	}
}
