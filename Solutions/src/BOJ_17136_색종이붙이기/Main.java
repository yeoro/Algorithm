package BOJ_17136_색종이붙이기;

import java.io.*;
import java.util.*;

class Main {
	
	static int[][] paper;
	static boolean[][] v, pv;
	static int[] pCnt;
	static boolean pCheck = true, check;
	static int min = Integer.MAX_VALUE, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		paper = new int[10][10];
		v = new boolean[10][10];
		pv = new boolean[10][10];
		pCnt = new int[6];
		
		Arrays.fill(pCnt, 5);
		
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < 10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				
				if(paper[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		System.out.println("---------" + cnt);
		if(cnt == 0) {
			System.out.println(0);
		} else {
			solve(0);
			
			if(!pCheck) {
				System.out.println(-1);
			} else {
				System.out.println(min);
			}
		}
		
		br.close();
	}
	
	private static void solve(int p) {
		if(p > cnt) {
			return;
		}
		
		if(p == cnt) {
			int temp = 0;
			
			for(int i = 1; i <= 5; i++) {
				if(pCnt[i] < 0) {
					pCheck = false;
					return;
				}
				
				temp += 5 - pCnt[i];
			}
			
			check = true;
			
			System.out.println(temp);
			min = Math.min(min, temp);
			
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(paper[i][j] == 1 && !pv[i][j] && !v[i][j]) {
					pv[i][j] = true;
					
					for(int k = 4; k >= 0; k--) {
						if(pCnt[k+1] > 0 && isColored(i, j, k)) {
							pCnt[k+1]--;
							draw(i, j, k);
							System.out.println(i + " " + j + " " + k + " " + p );
							solve(p + (k+1)*(k+1));
							unDraw(i, j, k);
							pCnt[k+1]++;
						}
					}
					
				}
			}
		}
	}
	
	private static boolean isColored(int x, int y, int k) {
		for(int i = x; i <= x+k; i++) {
			for(int j = y; j <= y+k; j++) {
				if(!isIn(i, j) || paper[i][j] == 0 || v[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < 10 && y >= 0 && y < 10;
	}
	
	private static void draw(int x, int y, int k) {
		for(int i = x; i <= x+k; i++) {
			for(int j = y; j <= y+k; j++) {
				v[i][j] = true;
			}
		}
	}
	
	private static void unDraw(int x, int y, int k) {
		for(int i = x; i <= x+k; i++) {
			for(int j = y; j <= y+k; j++) {
				v[i][j] = false;
			}
		}
	}
}

