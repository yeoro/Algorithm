package BOJ_05427_불;

import java.io.*;
import java.util.*;

public class BOJ_05427_불 {
	
	static char[][] building;
	static int[][] v;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int TC, w, h, time;
	static Queue<Node> sq, fq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			building = new char[h][w];
			v = new int[h][w];
			
			sq = new LinkedList<Node>();
			fq = new LinkedList<Node>();
			
			time = Integer.MAX_VALUE;
			
			for(int i = 0; i < h; i++) {
				String temp = br.readLine();
				for(int j = 0; j < w; j++) {
					building[i][j] = temp.charAt(j);
					
					char c = temp.charAt(j);
					
					if(c == '@') {
						v[i][j] = 1;
						sq.add(new Node(i, j, 1));
					}
					
					if(c == '#') {
						v[i][j] = -1;
					}
					
					if(c == '*') {
						v[i][j] = -1;
						fq.add(new Node(i, j, 0));
					}
				}
			}
			
			bfs();
			
			if(time == Integer.MAX_VALUE) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(time);
			}
		}
		
		br.close();
	}
	
	private static void bfs() {
		while(!sq.isEmpty()) {
			
			// 불 이동
			int size = fq.size();
			for(int i = 0; i < size; i++) {
				Node n = fq.poll();
				
				for(int j = 0; j < 4; j++) {
					int nx = n.x + dx[j];
					int ny = n.y + dy[j];
					
					if(isIn(nx, ny) && v[nx][ny] != -1) {
						v[nx][ny] = -1;
						fq.add(new Node(nx, ny, 0));
					}
				}
			}
			
			// 상근이 이동
			size = sq.size();
			for(int i = 0; i < size; i++) {
				Node n = sq.poll();

				for(int j = 0; j < 4; j++) {
					int nx = n.x + dx[j];
					int ny = n.y + dy[j];
					
					if(!isIn(nx, ny)) {
						time = Math.min(time, n.time);
						continue;
					}
					
					if(isIn(nx, ny) && v[nx][ny] != -1 && v[nx][ny] != 1) {
						v[nx][ny] = 1;
						sq.add(new Node(nx, ny, n.time+1));
					}
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < h && y >= 0 && y < w;
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

