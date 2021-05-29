package BOJ_01937_øÂΩ…¿Ô¿Ã∆«¥Ÿ;

import java.io.*;
import java.util.*;

class Main {
	
	static class Bamboo implements Comparable<Bamboo> {
		int x, y, time;

		public Bamboo(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Bamboo o) {
			return Integer.compare(this.time, o.time);
		}
	}
	static ArrayList<Bamboo> list = new ArrayList<Main.Bamboo>();
	static int[][] forest, dp;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int n, max = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		forest = new int[n][n];
		dp = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < n; j++) {
				forest[i][j] = Integer.parseInt(st.nextToken());
				
				list.add(new Bamboo(i, j, forest[i][j]));
			}
		}
		
		Collections.sort(list);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				dp[i][j] = 1;
			}
		}
		
		for(Bamboo b : list) {
			solve(b.x, b.y);
		}
		
		System.out.println(max);
		
		br.close();
	}
	
	private static void solve(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isIn(nx, ny) && forest[x][y] < forest[nx][ny]) {
				dp[nx][ny] = Math.max(dp[nx][ny], dp[x][y]+1);
				max = Math.max(dp[nx][ny], max);
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}

