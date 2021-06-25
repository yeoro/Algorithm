package BOJ_20061_모노미노도미노2;

import java.io.*;
import java.util.*;

class Main {
	
	static int[][] board = new int[10][10];
	static int ans, tile;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			solve(t, x, y);
		}
		
		cntTile();

		br.close();
	}
	
	private static void solve(int t, int x, int y) {
		put(t, x, y);

		score();
		
		special();
	}
	
	private static void put(int t, int x, int y) {
		switch(t) {
		case 1:
			// 파란 보드로 이동
			int hx = x; int hy = y;
			while(isIn(hx, hy) && board[hx][hy] == 0) {
				hy++;
			}
			board[x][hy-1] = 1;
			
			// 초록 보드로 이동
			hx = x; hy = y;
			while(isIn(hx, hy) && board[hx][hy] == 0) {
				hx++;
			}
			board[hx-1][y] = 1;
			
			break;
		case 2:
			// 파란 보드로 이동
			hx = x; hy = y;
			int tx = x; int ty = y+1;
			while(isIn(tx, ty) && board[tx][ty] == 0) {
				hy++; ty++;
			}
			board[hx][hy-1] = 1;
			board[tx][ty-1] = 1;
			
			// 초록 보드로 이동
			hx = x; hy = y;
			tx = x; ty = y+1;
			while(isIn(hx, hy) && isIn(tx, ty) && board[hx][hy] == 0 && board[tx][ty] == 0) {
				hx++; tx++;
			}
			board[hx-1][hy] = 1;
			board[tx-1][ty] = 1;

			break;
		case 3:
			// 파란 보드로 이동
			hx = x; hy = y;
			tx = x+1; ty = y;
			while(isIn(hx, hy) && isIn(tx, ty) && board[hx][hy] == 0 && board[tx][ty] == 0) {
				hy++; ty++;
			}
			board[hx][hy-1] = 1;
			board[tx][ty-1] = 1;
			
			// 초록 보드로 이동
			hx = x; hy = y;
			tx = x+1; ty = y;
			while(isIn(hx, hy) && isIn(tx, ty) && board[hx][hy] == 0 && board[tx][ty] == 0) {
				hx++; tx++;
			}
			board[hx-1][hy] = 1;
			board[tx-1][ty] = 1;
			
			break;
		}
	}
	
	private static void score() {
		// 파란 보드
		for(int col = 9; col >= 4; col--) {
			int cnt = 0;
			
			for(int row = 0; row < 4; row++) {
				if(board[row][col] == 1) {
					cnt++;
				}
			}
			
			// 블록 삭제
			if(cnt == 4) {
				for(int up = col; up >= 4; up--) {
					for(int row = 0; row < 4; row++) {
						board[row][up] = board[row][up-1];
					}
				}
				++col;
				ans++;
			}
		}
		
		// 초록 보드
		for(int row = 9; row >= 4; row--) {
			int cnt = 0;
			for(int col = 0; col < 4; col++) {
				if(board[row][col] == 1) {
					cnt++;
				}
			}
			
			// 블록 삭제
			if(cnt == 4) {
				for(int up = row; up >= 4; up--) {
					for(int col = 0; col < 4; col++) {
						board[up][col] = board[up-1][col];
					}
				}
				ans++;
				++row;
			}
		}
	}
	
	private static void special() {
		// 파란색 보드
		while(true) {
			boolean blue = false; int idx = 0;
			
			// 0, 1열에 블록이 있는지 확인
			loop: for(int col = 4; col < 6; col++) {
				for(int row = 0; row < 4; row++) {
					if(board[row][col] == 1) {
						idx = col;
						blue = true;
						break loop;
					}
				}
			}
			
			if(!blue) break;
			
			int cnt = 0;
			loop: for(int col = 4; col < 10; col++) {
				for(int row = 0; row < 4; row++) {
					if(board[row][col] == 1) {
						cnt++;
						continue loop;
					}
				}
			}
			
			for(int col = idx+cnt-1; col >= 4; col--) {
				for(int row = 0; row < 4; row++) {
					board[row][col] = board[row][col-1];
				}
			}
		}
		
		// 초록색 보드
		while(true) {
			boolean green = false; int idx = 0;

			// 0, 1열에 블록이 있는지 확인
			loop: for(int row = 4; row < 6; row++) {
				for(int col = 0; col < 4; col++) {
					if(board[row][col] == 1) {
						idx = row;
						green = true;
						break loop;
					}
				}
			}

			if(!green) break;

			int cnt = 0;
			loop: for(int row = 4; row < 10; row++) {
				for(int col = 0; col < 4; col++) {
					if(board[row][col] == 1) {
						cnt++;
						continue loop;
					}
				}
			}

			for(int row = idx+cnt-1; row >= 4; row--) {
				for(int col = 0; col < 4; col++) {
					board[row][col] = board[row-1][col];
				}
			}
		}
	}
	
	private static void cntTile() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(board[i][j] == 1) {
					tile++;
				}
			}
		}
		
		System.out.println(ans);
		System.out.println(tile);
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < 10 && y >= 0 && y < 10;
	}
}