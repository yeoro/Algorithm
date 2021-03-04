package BOJ_03055_≈ª√‚;

import java.io.*;
import java.util.*;

public class BOJ_03055_≈ª√‚ {
	
	static char[][] forest;
	static int[][] v;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int R, C, res;
	static Queue<Node> wq, hq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		forest = new char[R][C];
		v = new int[R][C];
		
		wq = new LinkedList<Node>();
		hq = new LinkedList<Node>();
		
		for(int i = 0; i < R; i++) {
			String temp = br.readLine();
			for(int j = 0; j < C; j++) {
				forest[i][j] = temp.charAt(j);
				
				if(forest[i][j] == '*') {
					v[i][j] = -1;
					wq.add(new Node(i, j, 0));
				}
				
				if(forest[i][j] == 'X' || forest[i][j] == 'D') {
					v[i][j] = -1;
				}
				
				if(forest[i][j] == 'S') {
					v[i][j] = 1;
					hq.add(new Node(i, j, 1));
				}
			}
		}
		
		bfs();
		
		if(res == 0) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(res);
		}
		
		br.close();
	}
	
	private static void bfs() {
		while(!hq.isEmpty()) {
			
			for(int i = 0, size = wq.size(); i < size; i++) {
				Node water = wq.poll();
				
				int x = water.x;
				int y = water.y;
				
				for(int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(isIn(nx, ny) && v[nx][ny] != -1) {
						v[nx][ny] = -1;
						wq.add(new Node(nx, ny, 0));
					}
				}
			}
			
			for(int i = 0, size = hq.size(); i < size; i++) {
				Node hedgehog = hq.poll();
				
				int x = hedgehog.x;
				int y = hedgehog.y;
				int time = hedgehog.time;
				
				for(int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(isIn(nx, ny)) {
						if(v[nx][ny] == 0) {
							v[nx][ny] = 1;
							hq.add(new Node(nx, ny, time+1));
						} else if(forest[nx][ny] == 'D') {
							res = time;
							return;
						}
					}
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}

class Node {
	int x, y, time;

	public Node(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

