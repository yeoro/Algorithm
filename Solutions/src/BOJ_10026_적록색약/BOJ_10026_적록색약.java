package BOJ_10026_적록색약;

import java.io.*;
import java.util.*;

public class BOJ_10026_적록색약 {
	
	static char[][] map;
	static boolean[][] vNormal, vWeak;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N, cntNormal, cntWeak;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		vNormal = new boolean[N][N];
		vWeak = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j);
			}
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!vNormal[i][j]) {
					vNormal[i][j] = true;
					normal(i, j);
					cntNormal++;
				}
				if(!vWeak[i][j]) {
					vWeak[i][j] = true;
					weak(i, j);
					cntWeak++;
				}
			}
		}
		
		System.out.println(cntNormal + " " + cntWeak);
		
		br.close();
	}
	
	private static void normal(int x, int y) {
		Queue<Color> q = new LinkedList<Color>();
		q.add(new Color(x, y));
		
		while(!q.isEmpty()) {
			Color c = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];
				
				if(isIn(nx, ny) && !vNormal[nx][ny] && map[nx][ny] == map[c.x][c.y]) {
					vNormal[nx][ny] = true;
					q.add(new Color(nx, ny));
				}
			}
		}
	}
	
	private static void weak(int x, int y) {
		Queue<Color> q = new LinkedList<Color>();
		q.add(new Color(x, y));
		
		while(!q.isEmpty()) {
			Color c = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];
				
				if(isIn(nx, ny) && !vWeak[nx][ny]) {
					if(isRedGreen(nx, ny) && isRedGreen(c.x, c.y)) {
						vWeak[nx][ny] = true;
						q.add(new Color(nx, ny));
					} else if (map[nx][ny] == 'B' && map[c.x][c.y] == 'B') {
						vWeak[nx][ny] = true;
						q.add(new Color(nx, ny));
					}
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
	private static boolean isRedGreen(int x, int y) {
		return map[x][y] == 'R' || map[x][y] == 'G';
	}
}

class Color {
	int x, y;

	public Color(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

