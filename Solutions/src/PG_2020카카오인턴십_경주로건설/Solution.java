package PG_2020카카오인턴십_경주로건설;

import java.io.*;
import java.util.*;

class Solution {
	
	static class Load {
		int x, y, dir, cost;

		public Load(int x, int y, int dir, int cost) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Load [x=" + x + ", y=" + y + ", dir=" + dir + ", cost=" + cost + "]";
		}
	}
	static int[][] copy;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0,0}, {0,1,1,1,1,0}, {0,0,1,0,0,0}, {1,0,0,1,0,1}, 
				{0,1,0,0,0,1}, {0,1,0,0,0,1}};
//		int[][] board = {{0,0,1,0}, {0,0,0,0}, {0,1,0,1}, {1,0,0,0}};
//		int[][] board = {{0,0,0}, {0,0,0}, {0,0,0}};
		
		int answer = 0;
		
		N = board.length;
		v = new boolean[N][N];
		copy = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				copy[i][j] = Integer.MAX_VALUE;
			}
		}
		
		copy[0][0] = 0;
		v[0][0] = true;
		
		bfs(0, 0, board);

		answer = min;
	}
	
	private static void bfs(int x, int y, int[][] board) {
		Queue<Load> q = new LinkedList<Load>();
		q.offer(new Load(x, y, -1, 0));
		
		while(!q.isEmpty()) {
			Load cur = q.poll();
				
			int cx = cur.x;
			int cy = cur.y;
			int dir = cur.dir;
			int cost = cur.cost;
			
			if(cx == N-1 && cy == N-1) {
				min = Math.min(min, cost);
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(isIn(nx, ny) && board[nx][ny] != 1) {
					if(dir == -1 || dir == i) {
						if(copy[nx][ny] >= cost+100) {
							copy[nx][ny] = cost+100;
							q.offer(new Load(nx, ny, i, cost+100));
						}
					} else {
						if(copy[nx][ny] >= cost+600) {
							copy[nx][ny] = cost+600;
							q.offer(new Load(nx, ny, i, cost+600));
						}
					}
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

