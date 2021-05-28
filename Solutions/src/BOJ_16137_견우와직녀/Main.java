package BOJ_16137_견우와직녀;

import java.io.*;
import java.util.*;

class Main {

	static class Node {
		int x, y, time;
		boolean cross;

		public Node(int x, int y, int time, boolean cross) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.cross = cross;
		}
	}
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N, M, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					if(!isCross(i, j)) {
						v = new boolean[N][N];
						map[i][j] = M;
						solve(0, 0);
						map[i][j] = 0;
					}
				}
			}
		}
		
		System.out.println(min);
		
		br.close();
	}
	
	private static boolean isCross(int x, int y) {
		boolean ud = false;
		boolean lr = false;
		
		for(int i = 0; i < 2; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isIn(nx, ny) && (map[nx][ny] == 0 || map[nx][ny] == -1)) {
				ud = true;
				break;
			}
		}
		
		for(int i = 2; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isIn(nx, ny) && (map[nx][ny] == 0 || map[nx][ny] == -1)) {
				lr = true;
				break;
			}
		}
		
		if(lr && ud) {
			return true;
		}
		
		return false;
	}
	
	private static void solve(int x, int y) {
		Queue<Node> q = new LinkedList<Main.Node>();
		q.offer(new Node(x, y, 0, false));
		v[x][y] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			x = cur.x;
			y = cur.y;
			int time = cur.time;
			boolean cross = cur.cross;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(isIn(nx, ny) && !v[nx][ny]) {
					// 일반 땅
					if(map[nx][ny] == 1) {
						if(nx == N-1 && ny == N-1) {
							min = Math.min(min, time+1);
							return;
						}
						
						v[nx][ny] = true;
						q.offer(new Node(nx, ny, time+1, false));
					}
					
					// 다리	
					if(!cross && map[nx][ny] >= 2) {
						if((time+1) % map[nx][ny] == 0) {
							v[nx][ny] = true;
							q.offer(new Node(nx, ny, time+1, true));
						} else {
							// 다리를 못 건너는 경우 기다렸다가 가야함
							q.offer(new Node(x, y, time+1, false));
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