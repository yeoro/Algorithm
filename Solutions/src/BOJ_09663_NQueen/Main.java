package BOJ_09663_NQueen;

import java.io.*;
import java.util.*;

class Main {

	static int[] board;
	static int N, cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		board = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			board[1] = i;
			
			solve(1);
		}

		
		System.out.println(cnt);

		sc.close();
	}

	private static void solve(int depth) {
		if(depth == N) {
			cnt++;
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			board[depth+1] = i;
			
			if(isPossible(i)) {
				solve(depth+1);
			}
		}
	}

	private static boolean isPossible(int idx) {
		for(int i = 1; i <= idx; i++) {
			if(board[i] == board[idx] || Math.abs(i - idx) == Math.abs(board[i] - board[idx])) {
				return false;
			}
		}
		
		return true;
	}
}

