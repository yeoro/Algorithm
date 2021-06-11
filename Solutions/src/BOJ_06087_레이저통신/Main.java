package BOJ_06087_레이저통신;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node implements Comparable<Node> {
		int x, y, dir, mirror;

		public Node(int x, int y, int dir, int mirror) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.mirror = mirror;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.mirror, o.mirror);
		}
	}
	static char[][] map;
	static int[][] dis;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int W, H, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		
		for(int i = 0; i < H; i++) {
			String input = br.readLine();
			
			for(int j = 0; j < W; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j] == 'C') {
					dis = new int[H][W];
					
					initDis();
					
					solve(i, j);
				}
			}
		}
		
		System.out.println(min);
		
		br.close();
	}
	
	private static void initDis() {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				dis[i][j] = Integer.MAX_VALUE;
			}
		}
	}
	
	private static void solve(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<Main.Node>();
		pq.offer(new Node(x, y, -1, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			x = cur.x;
			y = cur.y;
			int dir = cur.dir;
			int mirror = cur.mirror;
			
			if(map[x][y] == 'C' && dir != -1) {
				min = Math.min(min, mirror);
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(isIn(nx, ny) && map[nx][ny] != '*') {
					if(dir == -1 || dir == i) {
						if(dis[nx][ny] >= mirror) {
							dis[nx][ny] = mirror;
							pq.offer(new Node(nx, ny, i, mirror));
						}
					} 
					
					if(dir != i) {
						if(dis[nx][ny] >= mirror+1) {
							dis[nx][ny] = mirror+1;
							pq.offer(new Node(nx, ny, i, mirror+1));
						}
					} 
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}
}

