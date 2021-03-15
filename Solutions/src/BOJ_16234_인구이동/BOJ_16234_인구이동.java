package BOJ_16234_인구이동;

import java.io.*;
import java.util.*;

public class BOJ_16234_인구이동 {
	
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N, L, R, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve();
		
		System.out.println(cnt);
		
		br.close();
	}
	
	private static void solve() {
		boolean check;
		
		while(true) {
			check = false;
			
			v = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!v[i][j]) {
						v[i][j] = true;
						if(open(i, j)) {
							check = true;
						} 
					}	
				}
			}
			
			if(!check) {
				break;
			}
			
			cnt++;
		}
	}
	
	private static boolean open(int x, int y) {
		boolean check = false;
		
		Queue<Country> q = new LinkedList<Country>();
		q.add(new Country(x, y));
		
		ArrayList<Country> openList = new ArrayList<Country>();
		openList.add(new Country(x, y));
		
		while(!q.isEmpty()) {
			Country c = q.poll();
			int cx = c.x;
			int cy = c.y;
			
			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(isIn(nx, ny) && !v[nx][ny] && canOpen(cx, cy, nx, ny)) {
					v[nx][ny] = true;
					q.add(new Country(nx, ny));
					openList.add(new Country(nx, ny));
				}
			}
		}
		
		if(openList.size() >= 2) {
			int sum = 0;
			
			for(Country c : openList) {
				sum += map[c.x][c.y];
			}
			
			for(Country c : openList) {
				map[c.x][c.y] = sum / openList.size();
			}
			
			check = true;
		}
		
		return check;
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
	private static boolean canOpen(int x1, int y1, int x2, int y2) {
		int dif = Math.abs(map[x1][y1] - map[x2][y2]); 
		return dif >= L && dif <= R;
	}
}

class Country {
	int x, y;

	public Country(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

