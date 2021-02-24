package BOJ_07562_나이트의이동;

import java.io.*;
import java.util.*;

public class BOJ_07562_나이트의이동 {
	
	static int[][] chess;
	static boolean[][] v;
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	static int l, xTo, yTo, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < TC; tc++) {
			l = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			xTo = Integer.parseInt(st.nextToken());
			yTo = Integer.parseInt(st.nextToken());
			
			chess = new int[l][l];
			v = new boolean[l][l];
			cnt = Integer.MAX_VALUE;
			
			v[x][y] = true;
			
			if(x == xTo && y == yTo) {
				bw.write("0\n");
				continue;
			}
			
			bfs(x, y);
			
			bw.write(cnt + "\n");
		}
		br.close();
		bw.flush();
	}
	
	private static void bfs(int x, int y) {
		Queue<Knight> q = new LinkedList<Knight>();
		q.add(new Knight(x, y));
		
		while(!q.isEmpty()) {
			Knight k = q.poll();
			
			for(int i = 0; i < 8; i++) {
				int nx = k.x + dx[i];
				int ny = k.y + dy[i];

				if(isIn(nx, ny) && !v[nx][ny]) {
					v[nx][ny] = true;
					chess[nx][ny] = chess[k.x][k.y]+1;
					
					if(nx == xTo && ny == yTo) {
						cnt = Math.min(cnt, chess[nx][ny]);
						continue;
					}
					
					q.add(new Knight(nx, ny));
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < l && y >= 0 && y < l;
	}
}

class Knight {
	int x, y;

	public Knight(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

