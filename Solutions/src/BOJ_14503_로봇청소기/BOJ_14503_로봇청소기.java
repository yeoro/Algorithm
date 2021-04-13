package BOJ_14503_로봇청소기;

import java.io.*;
import java.util.*;

public class BOJ_14503_로봇청소기 {
	
	static boolean[][] v;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	static int N, M, r, c, d, res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		v = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(r, c, d);
		
		System.out.println(res+1);
		
		br.close();
	}
	
	private static void clean(int x, int y, int dir) {
		// 현재 위치 청소
		map[x][y] = -1;
		
		int nDir = dir;
		
		// 네 방향을 탐색하며 청소할 곳 찾음
		for(int i = 0; i < 4; i++) { 
			nDir = (nDir + 3) % 4;
			
			int nx = x + dx[nDir];
			int ny = y + dy[nDir];
			
			// 청소할 곳을 찾았다면 재귀호출 후 현재 함수 종료
			if(map[nx][ny] == 0) {
				res++;
				clean(nx, ny, nDir);
				return;
			}
		}
		
		// 네 방향을 탐색하고도 청소할 곳을 찾지 못했다면 후진 후 다시 탐색
		int bx = x - dx[dir];
		int by = y - dy[dir];
		
		// 벽이라서 후진도 못하는 경우 종료
		if(map[bx][by] == 1) {
			return;
		} else {
			clean(x-dx[dir], y-dy[dir], dir);
		}
	}
}

