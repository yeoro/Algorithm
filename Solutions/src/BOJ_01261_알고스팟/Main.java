package BOJ_01261_¾Ë°í½ºÆÌ;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node implements Comparable<Node> {
		int x, y, cnt;

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cnt, o.cnt);
		}
	}
	static int[][] maze;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N, M, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		maze = new int[N+1][M+1];
		v = new boolean[N+1][M+1];

		for(int i = 1; i <= N; i++) {
			String input = br.readLine();
			
			for(int j = 1; j <= M; j++) {
				maze[i][j] = Integer.parseInt(input.charAt(j-1)+"");
			}
		}
		
		solve(1, 1);
		
		br.close();
	}
	
	private static void solve(int x, int y) {
		PriorityQueue<Node> q = new PriorityQueue<Main.Node>();
		q.offer(new Node(x, y, 0));
		v[x][y] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			x = cur.x;
			y = cur.y;
			int cnt = cur.cnt;
			
			if(x == N && y == M) {
				System.out.println(cnt);
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(isIn(nx, ny) && !v[nx][ny]) {
					if(maze[nx][ny] == 0) {
						q.offer(new Node(nx, ny, cnt));
					}
					
					if(maze[nx][ny] == 1) {
						q.offer(new Node(nx, ny, cnt+1));
					}
					
					v[nx][ny] = true;
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 1 && x <= N && y >= 1 && y <= M;
	}
}