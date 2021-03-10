package BOJ_17070_파이프옮기기1;

import java.io.*;
import java.util.*;

public class BOJ_17070_파이프옮기기1 {
	
	static int[][] home;
	static int[][] dx = {{0, 0, 1}, {0, 1, 1}, {0, 1, 1}}, dy = {{1, 0, 1}, {0, 0, 1}, {1, 0, 1}};
	static int N, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		home = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 1, 0);
		
		System.out.println(cnt);
		
		br.close();
	}
	
	private static void dfs(int x, int y, int dir) {
		if(x == N-1 && y == N-1) {
			cnt++;
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			if(dx[dir][i] == 0 && dy[dir][i] == 0) {
				continue;
			}
			
			int nx = x + dx[dir][i];
			int ny = y + dy[dir][i];
			
			if(isIn(nx, ny) && home[nx][ny] == 0) {
				switch(i) {
				case 0:
				case 1:
					dfs(nx, ny, i);
					break;
				case 2:
					if(home[x+1][y] == 0 && home[x][y+1] == 0) {
						dfs(nx, ny, i);
					}
					break;
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

