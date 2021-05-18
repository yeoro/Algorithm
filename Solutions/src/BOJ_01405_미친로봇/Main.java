package BOJ_01405_¹ÌÄ£·Îº¿;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node {
		int x, y, cnt;
		double prob;
		
		public Node(int x, int y, int cnt, double prob) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.prob = prob;
		}
	}
	static boolean[][] v = new boolean[29][29];
	static double[] p = new double[4];
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
	static double res;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < 4; i++) {
			p[i] = Double.parseDouble(st.nextToken()) / 100.0;
		}
		
		v[14][14] = true;
		move(14, 14, 0, 1.0);
		
		System.out.println(res);
		
		br.close();
	}
	
	private static void move(int x, int y, int cnt, double prob) {
		if(cnt == N) {
			res += prob;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!v[nx][ny]) {
				v[nx][ny] = true;
				move(nx, ny, cnt+1, prob*p[i]);
				v[nx][ny] = false;
			}
		}
	}
}

