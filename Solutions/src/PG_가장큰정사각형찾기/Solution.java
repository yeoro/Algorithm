package PG_가장큰정사각형찾기;

import java.io.*;
import java.util.*;

class Solution {

	static int N, M;
	
	public static void main(String[] args) {
		
		int[][] board = {{0,1,1,1}, {1,1,1,1}, {1,1,1,1}, {0,0,1,0}};
		
		N = board.length;
		M = board[0].length;
		int max = Math.min(N, M);
		int answer = 0;

		// 행 계산
		for(int i = 0; i < N; i++){
			for(int j = 1; j < M; j++){
				board[i][j] += board[i][j-1];
			}
		}

		// 열 계산
		for(int i = 0; i < M; i++){
			for(int j = 1; j < N; j++){
				board[j][i] += board[j-1][i];
			}
		}

		for(int k = max; k >= 1; k--){
			for(int i = 0; i <= N - k; i++){
				for(int j = 0; j <= M - k; j++){
					int check = (k) * (k);

					if(board[i][j] == 0){
						continue;
					}

					int cur = board[i+k][j+k];

					if(isIn(i+k, j-1)){
						cur -= board[i+k][j-1];
					}

					if(isIn(i-1, j+k)){
						cur -= board[i-1][j+k];
					}

					if(isIn(i-1, j-1)){
						cur += board[i-1][j-1];
					}

					// System.out.println(i + " " + j + " " + " " + k + " " + cur);

					if(cur == check){
//						return cur;
					}
				}
			}
		}

//		return answer;
	}

	private static boolean isIn(int x, int y){
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}

