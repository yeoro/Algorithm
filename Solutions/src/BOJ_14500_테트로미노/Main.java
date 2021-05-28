package BOJ_14500_테트로미노;

import java.io.*;
import java.util.*;

class Main {

	static int[][] paper;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N, M, max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		paper = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				solve(i, j, paper[i][j]);
			}
		}
		
		System.out.println(max);
		
		br.close();
	}
	
	private static void solve(int x, int y, int value) {
		// ──
		int temp = value;
		if(isIn(x, y+3)) {
			temp += paper[x][y+1] + paper[x][y+2] + paper[x][y+3];
			max = Math.max(max, temp);
		}
		
		// │
		temp = value;
		if(isIn(x+3, y)) {
			temp += paper[x+1][y] + paper[x+2][y] + paper[x+3][y];
			max = Math.max(max, temp);
		}
		
		// □
		temp = value;
		if(isIn(x+1, y+1)) {
			temp += paper[x+1][y] + paper[x][y+1] + paper[x+1][y+1];
			max = Math.max(max, temp);
		}
		
		if(isIn(x+2, y+1)) {
			// │
			// └─
			temp = value;
			temp += paper[x+1][y] + paper[x+2][y] + paper[x+2][y+1];
			max = Math.max(max, temp);

			// ─┐
			//  │
			temp = value;
			temp += paper[x][y+1] + paper[x+1][y+1] + paper[x+2][y+1];
			max = Math.max(max, temp);
		}
		
		if(isIn(x+1, y+2)) {
			// ┌──
			temp = value;
			temp += paper[x+1][y] + paper[x][y+1] + paper[x][y+2];
			max = Math.max(max, temp);
			
			// └──
			temp = value;
			temp += paper[x+1][y] + paper[x+1][y+1] + paper[x+1][y+2];
			max = Math.max(max, temp);
		}
		
		if(isIn(x+1, y-2)) {
			// ──┘
			temp = value;
			temp += paper[x+1][y] + paper[x+1][y-1] + paper[x+1][y-2];
			max = Math.max(max, temp);
			
			// ──┐
			temp = value;
			temp += paper[x+1][y] + paper[x][y-1] + paper[x][y-2];
			max = Math.max(max, temp);
		}
		
		if(isIn(x+2, y-1)) {
			//  │
			// ─┘
			temp = value;
			temp += paper[x+1][y] + paper[x+2][y] + paper[x+2][y-1];
			max = Math.max(max, temp);
			
			//  │
			// ┌┘
			// │
			temp = value;
			temp += paper[x+1][y] + paper[x+1][y-1] + paper[x+2][y-1];
			max = Math.max(max, temp);
			
			// ─┤
			temp = value;
			temp += paper[x+1][y] + paper[x+2][y] + paper[x+1][y-1];
			max = Math.max(max, temp);
		}
		
		if(isIn(x+2, y+1)) {
			// ┌─
			// │
			temp = value;
			temp += paper[x+1][y] + paper[x+2][y] + paper[x][y+1];
			max = Math.max(max, temp);
			
			// │
			// └┐
			//  │
			temp = value;
			temp += paper[x+1][y] + paper[x+1][y+1] + paper[x+2][y+1];
			max = Math.max(max, temp);
		
			// ├─
			temp = value;
			temp += paper[x+1][y] + paper[x+1][y+1] + paper[x+2][y];
			max = Math.max(max, temp);
		}
		
		// ─┐
		//  └─
		temp = value;
		if(isIn(x+1, y+2)) {
			temp += paper[x][y+1] + paper[x+1][y+1] + paper[x+1][y+2];
			max = Math.max(max, temp);
		}
		
		//  ┌─
		// ─┘
		temp = value;
		if(isIn(x+1, y-2)) {
			temp += paper[x][y-1] + paper[x+1][y-1] + paper[x+1][y-2];
			max = Math.max(max, temp);
		}
		
		if(isIn(x+1, y-1) && isIn(x+1, y+1)) {
			// ─┬─
			temp = value;
			temp += paper[x][y-1] + paper[x][y+1] + paper[x+1][y];
			max = Math.max(max, temp);
			
			// ─┴─
			temp = value;
			temp += paper[x+1][y] + paper[x+1][y-1] + paper[x+1][y+1];
			max = Math.max(max, temp);
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}