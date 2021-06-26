package Softeer_level2_장애물인식프로그램;

import java.util.*;
import java.io.*;

public class Main {
	
	static class Block {
		int x, y;

		public Block (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1}, cnt;
	static int N, group;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		v = new boolean[N][N];

		for(int i = 0; i < N; i++) {
			String input = br.readLine();

			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input.charAt(j)+"") ;
			}
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!v[i][j] && map[i][j] == 1) {
					solve(i, j);
					group++;
				}
			}
		}

		cnt = new int[group];

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] != 0) {
					cnt[map[i][j]-1]++;
				}
			}
		}

		Arrays.sort(cnt);

		System.out.println(group);
		for(int i = 0; i < group; i++) {
			System.out.println(cnt[i]);
		}

		br.close();
	}

	private static void solve(int x, int y) {
		Queue<Block> q = new LinkedList<Block>();
		q.offer(new Block(x, y));
		v[x][y] = true;
		map[x][y] = group+1;

		while(!q.isEmpty()) {
			Block cur = q.poll();
			x = cur.x;
			y = cur.y;

			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(isIn(nx, ny) && !v[nx][ny] && map[nx][ny] == 1) {
					v[nx][ny] = true;
					map[nx][ny] = group+1;
					q.offer(new Block(nx, ny));
				}
			}
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}