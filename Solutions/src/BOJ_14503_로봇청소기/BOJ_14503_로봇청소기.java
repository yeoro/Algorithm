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
		
		map[r][c] = 2;
		
		clean(r, c, d, 1);
		
		System.out.println(res);
		br.close();
	}
	
	private static void clean(int x, int y, int dir, int cnt) {
//		if(cnt == 30) {
//			return;
//		}
		
		// 현재 위치 청소
		map[x][y] = 2;
		
		int curDir = dir;
		int curCnt = cnt;
		int nx = x;
		int ny = y;
		int check = 0;

//		System.out.println("현재 위치 (" + nx + ", " + ny + ") " + cnt);
//		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		// 돌면서 청소할 곳 찾기
		while(true) {
			switch(curDir) {
			case 0: // 북
				curDir = 3;
				check++;
//				System.out.println("서: " + check);
				break;
			case 1: // 동
				curDir = 0;
				check++;
//				System.out.println("북: " + check);
				break;
			case 2: // 남
				curDir = 1;
				check++;
//				System.out.println("동: " + check);
				break;
			case 3: // 서
				curDir = 2;
				check++;
//				System.out.println("남: " + check);
				break;
			}

			nx = x + dx[curDir];
			ny = y + dy[curDir];

//			System.out.println("변환 (" + nx + ", " + ny + ") " + curDir);
			
			
			// 청소할 공간을 찾으면 다음 청소 진행
			if(isIn(nx, ny) && map[nx][ny] == 0) {
				clean(nx, ny, curDir, curCnt+1);
//				System.out.println("청소 (" + nx + ", " + ny + ")");
				return;
			} else { // 왼쪽 방향에 청소할 공간이 없다면 회전 후 다시 탐색
				if(check == 4) {
					// 네 방향 모두 청소를 했거나 벽인 경우 한 칸 후진
					switch(curDir) {
					case 0: // 북
						nx = x+1;
						break;
					case 1: // 동
						ny = y-1;
						break;
					case 2: // 남
						nx = x-1;
						break;
					case 3: // 서
						ny = y+1;
						break;
					}
					
					if(isIn(nx, ny)) {
//						System.out.println("후진 (" + nx + ", " + ny + ")");
						clean(nx, ny, curDir, curCnt);
						break;
					} else if(!isIn(nx, ny) && map[nx][ny] != 0){
						res = cnt;
						return;
					}
				}
			}
		}
	}
	
	
	private static boolean isIn(int x, int y) {
		return x > 0 && x < N-1 && y > 0 && y < M-1;
	}
}

