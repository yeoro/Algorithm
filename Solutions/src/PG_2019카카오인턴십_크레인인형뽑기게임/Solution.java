package PG_2019카카오인턴십_크레인인형뽑기게임;

import java.io.*;
import java.util.*;

class Solution {
	
	static Stack<Integer> stack = new Stack<Integer>();
	static int[][] board_copy;
	static int[] moves_copy;
	static int N, M, answer;
	
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		N = board.length;
		M = moves.length;
		
		board_copy = board;
		moves_copy = moves;
		
		solve();
	}
	
	private static void solve() {
		for(int i = 0; i < M; i++) {
			bomb(pick(moves_copy[i]-1));
		}
		
		System.out.println(answer);
	}
	
	private static int pick(int mIdx) {
		for(int i = 0; i < N; i++) {
			int doll = board_copy[i][mIdx];
			
			if(doll != 0) {
				board_copy[i][mIdx] = 0;
				return doll;
			}
		}
		
		return -1;
	}
	
	private static void bomb(int doll) {
		if(doll != -1) {
			if(stack.size() == 0) {
				stack.push(doll);
				return;
			}
			
			if(stack.peek() == doll) {
				answer += 2;
				stack.pop();
			} else {
				stack.push(doll);
			}
		}
	}
}

