package BOJ_03187_¾çÄ¡±â²á;

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
	static char[][] farm;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int R, C, sheep, wolf;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		farm = new char[R][C];
		v = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			String input = br.readLine();
			
			for(int j = 0; j < C; j++) {
				farm[i][j] = input.charAt(j);
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(!v[i][j]) {
					if(farm[i][j] == 'k') {
						v[i][j] = true;
						bfs(new Node(i, j), farm[i][j]);
					} else if(farm[i][j] == 'v') {
						v[i][j] = true;
						bfs(new Node(i, j), farm[i][j]);
					}
				}
			}
		}
		
		System.out.println(sheep + " " + wolf);
		
		br.close();
	}
	
	private static void bfs(Node n, char species) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(n);
		int curSheep = 0, curWolf = 0;
		
		if(species == 'k') curSheep++;
		else curWolf++;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(isIn(nx, ny) && farm[nx][ny] != '#' && !v[nx][ny]) {
					if(farm[nx][ny] == 'v') curWolf++;
					if(farm[nx][ny] == 'k') curSheep++;

					v[nx][ny] = true;
					q.offer(new Node(nx, ny));
				}
			}
		}
		
		if(curSheep > curWolf) {
			sheep += curSheep;
		} else {
			wolf += curWolf;
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}