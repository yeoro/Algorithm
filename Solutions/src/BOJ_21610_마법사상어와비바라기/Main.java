package BOJ_21610_마법사상어와비바라기;

import java.io.*;
import java.util.*;

// 1시간 7분
class Main {
	
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
	}
	static Queue<Node> cloud = new LinkedList<Node>();
	static int[][] map;
	static boolean[][] v;
	static Node[] movements;
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1}, dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int N, M, res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		movements = new Node[M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			movements[i] = new Node(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
		}
		
		cloud.offer(new Node(N-1, 0));
		cloud.offer(new Node(N-1, 1));
		cloud.offer(new Node(N-2, 0));
		cloud.offer(new Node(N-2, 1));
		
		solve();
		
		System.out.println(res);
		
		br.close();
	}
	
	private static void solve() {
		for(int i = 0; i < M; i++) {
			v = new boolean[N][N];
			
			move(i);
			copy();
			makeCloud();
		}
		
		count();
	}
	
	private static void move(int idx) {
		Node curMove = movements[idx];
		int d = curMove.x;
		int s = curMove.y;
		
		for(int i = 0, size = cloud.size(); i < size; i++) {
			Node cur = cloud.poll();
			int x = cur.x;
			int y = cur.y;
			
			int nx = (x + dx[d]*s) % N;
			int ny = (y + dy[d]*s) % N;
			
			if(nx < 0) nx += N;
			if(ny < 0) ny += N;
			
			map[nx][ny]++;
			cloud.offer(new Node(nx, ny));
		}
	}
	
	private static void copy() {
		while(!cloud.isEmpty()) {
			Node cur = cloud.poll();
			int x = cur.x;
			int y = cur.y;
			
			int cnt = 0;
			
			for(int i = 1; i < 8; i+=2) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(isIn(nx, ny) && map[nx][ny] > 0) {
					cnt++;
				}
			}
			
			v[x][y] = true;
			map[x][y] += cnt;
		}
	}
	
	private static void makeCloud() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] >= 2 && !v[i][j]) {
					cloud.offer(new Node(i, j));
					map[i][j] -= 2;
				}
			} 
		}
	}
	
	private static void count() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				res += map[i][j];
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}