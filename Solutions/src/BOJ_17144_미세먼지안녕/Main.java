package BOJ_17144_미세먼지안녕;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node {
		int x, y, cnt;

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static Queue<Node> dusts = new LinkedList<Main.Node>();
	static ArrayList<Node> list = new ArrayList<Main.Node>();
	static int[][] room, copy;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int R, C, T;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		room = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				
				if(room[i][j] == -1) {
					list.add(new Node(i, j, room[i][j]));
				}
				
				if(room[i][j] > 0) {
					dusts.add(new Node(i, j, room[i][j]));
				}
			}
		}
		
		solve();
		
		br.close();
	}
	
	private static void solve() {
		for(int i = 0; i < T; i++) {
			copy = new int[R][C];
			
			spread();
			wind();
			copyArr();
			newDust();
		}

		cal();
	}
	
	private static void spread() {
		while(!dusts.isEmpty()) {			
			Node cur = dusts.poll();
			
			int dust = cur.cnt/5;
			int cnt = 0;

			for(int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if(isIn(nx, ny) && !isRobot(nx, ny)) {
					copy[nx][ny] += dust;
					cnt++;
				}
			}
			
			copy[cur.x][cur.y] += cur.cnt - dust*cnt;
		}
	}
	
	private static void wind() {
		Node up = list.get(0);
		Node down = list.get(1);
		
		// 반시계
		for(int i = up.x-1; i > 0; i--) {
			copy[i][up.y] = copy[i-1][up.y];
		}
		
		for(int i = up.y; i < C-1; i++) {
			copy[0][i] = copy[0][i+1];
		}
		
		for(int i = 0; i < up.x; i++) {
			copy[i][C-1] = copy[i+1][C-1];
		}
		
		for(int i = C-1; i > up.y; i--) {
			copy[up.x][i] = copy[up.x][i-1];
		}
		
		// 시계
		for(int i = down.x+1; i < R-1; i++) {
			copy[i][down.y] = copy[i+1][down.y];
		}
		
		for(int i = down.y; i < C-1; i++) {
			copy[R-1][i] = copy[R-1][i+1];
		}
		
		for(int i = R-1; i > down.x; i--) {
			copy[i][C-1] = copy[i-1][C-1];
		}

		for(int i = C-1; i > down.y; i--) {
			copy[down.x][i] = copy[down.x][i-1];
		}
	}
	
	private static void copyArr() {
		for(int i = 0; i < R; i++) {
			System.arraycopy(copy[i], 0, room[i], 0, copy[i].length);
		}
	}
	
	private static void newDust() {
		for(int k = 0; k < R; k++) {
			for(int j = 0; j < C; j++) {
				if(room[k][j] > 0) {
					dusts.offer(new Node(k, j, room[k][j]));
				}
			}
		}
	}
	
	private static void cal() {
		int sum = 0;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(room[i][j] > 0) {
					sum += room[i][j];
				}
			}
		}
		
		System.out.println(sum);
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
	
	private static boolean isRobot(int x, int y) {
		Node up = list.get(0);
		Node down = list.get(1);
		
		return (x == up.x && y == up.y) || (x == down.x && y == down.y);
	}
}