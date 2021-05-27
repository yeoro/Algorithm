package BOJ_10711_¸ð·¡¼º;

import java.io.*;
import java.util.*;

class Main {
	
	static class Castle {
		int x, y, hard;

		public Castle(int x, int y, int hard) {
			this.x = x;
			this.y = y;
			this.hard = hard;
		}
	}
	static ArrayList<Castle> fallList = new ArrayList<Castle>();
	static Queue<Castle> fallQ = new LinkedList<Main.Castle>();
	static boolean[][] v;
	static char[][] sand;
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0}, dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int H, W, res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		sand = new char[H][W];
		v = new boolean[H][W];
		
		for(int i = 0; i < H; i++) {
			String input = br.readLine();
			
			for(int j = 0; j < W; j++) {
				sand[i][j] = input.charAt(j);
			}
		}
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(sand[i][j] != '.') {
					int hard = Integer.parseInt(sand[i][j]+"");
					
					if(checkDot(i, j) >= hard) {
						v[i][j] = true;
						fallQ.add(new Castle(i, j, hard));
					}
				}
			}
		}
		
		solve();
		
		System.out.println(res);
		
		br.close();
	}
	
	private static void solve() {
		while(!fallQ.isEmpty()) {
			
			int size = fallQ.size();
			
			while(size-- > 0) {
				Castle cur = fallQ.poll();
				int x = cur.x;
				int y = cur.y;
				
				sand[x][y] = '.';
				
				for(int d = 0; d < 8; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(isIn(nx, ny) && !v[nx][ny] && sand[nx][ny] != '.') {
						int hard = Integer.parseInt(sand[nx][ny]+"");
						
						if(checkDot(nx, ny) >= hard) {
							v[nx][ny] = true;
							fallQ.add(new Castle(nx, ny, hard));
						}
					}
				}
			}
			
			res++;
		}
	}
	
	private static int checkDot(int x, int y) {
		int dot = 0;
		
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isIn(nx, ny) && sand[nx][ny] == '.') {
				dot++;
			}
		}
		
		return dot;
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}
}

