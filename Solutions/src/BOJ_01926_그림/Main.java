package BOJ_01926_±×¸²;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static boolean[][] v;
	static int[][] paper;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int n, m, max = Integer.MIN_VALUE, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		paper = new int[n][m];
		v = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(paper[i][j] == 1 && !v[i][j]) {
					v[i][j] = true;
					bfs(i, j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
		if(cnt == 0) {
			System.out.println(0);
		} else {
			System.out.println(max);
		}
		
		br.close();
	}
	
	private static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(x, y));
		
		int temp = 1;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			x = cur.x;
			y = cur.y;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(isIn(nx, ny) && !v[nx][ny] && paper[nx][ny] == 1) {
					v[nx][ny] = true;
					temp++;
					q.add(new Node(nx, ny));
				}
			}
		}
		
		max = Math.max(max, temp);
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}

