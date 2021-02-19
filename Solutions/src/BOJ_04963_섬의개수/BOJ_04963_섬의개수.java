package BOJ_04963_¼¶ÀÇ°³¼ö;

import java.io.*;
import java.util.*;

public class BOJ_04963_¼¶ÀÇ°³¼ö {
	
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int w, h, land;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) {
				break;
			}
			
			map = new int[h][w];
			v = new boolean[h][w];
			land = 0;
			
			for(int i = 0; i < h; i ++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < h; i ++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !v[i][j]) {
						v[i][j] = true;
						dfs(i, j);
						land++;
					}
				}
			}
			
			bw.write(land + "\n");
		}
		
		br.close();
		bw.flush();
	}
	
	private static void dfs(int x, int y) {
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isIn(nx, ny) && !v[nx][ny] && map[nx][ny] == 1) {
				v[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < h && y >= 0 && y < w;
	}
}

