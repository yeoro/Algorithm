package PG_2020KAKAO_블록이동하기;

import java.io.*;
import java.util.*;

class Solution {

	static boolean[][] v;
	static Node[] robot;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N, answer;

	public static void main(String[] args) {

		int[][] board = {{0,0,0,1,1}, {0,0,0,1,0}, {0,1,0,1,1}, {1,1,0,0,1}, {0,0,0,0,0}};
		
		N = board.length;

		v = new boolean[board.length][board[0].length];
		v[0][0] = true;
		v[0][1] = true;

		robot = new Node[3];
		robot[0] = new Node(0, 0);
		robot[1] = new Node(0, 1);
		robot[2] = new Node(0, 0);

		go(board);

//		return answer;
	}

	private static void go(int[][] board) {
		Queue<Node[]> q = new LinkedList<Node[]>();
		q.offer(robot);

		while(!q.isEmpty()){
			Node[] cur = q.poll();

			Node left = cur[0];
			Node right = cur[1];
			Node cnt = cur[2];

			System.out.println("left: " + left.toString());
			System.out.println("right: " + right.toString());
			System.out.println("cnt: " + cnt.x);

			if(isArrived(left.x, left.y) || isArrived(right.x, right.y)) {
				answer = cnt.x;
				return;
			}

			// 상, 하, 좌, 우 이동
			for(int i = 0; i < 4; i++){
				int lx = left.x + dx[i];
				int ly = left.y + dy[i];
				int rx = right.x + dx[i];
				int ry = right.y + dy[i];

				switch(i) {
				case 0:
				case 1:
					if(isIn(lx, ly) && isIn(rx, ry)) {
						if(board[lx][ly] == 0 && board[rx][ry] == 0) {
							if(!v[lx][ly] && !v[rx][ry]) {
								Node[] move = new Node[3];
								move[0] = new Node(lx, ly);
								move[1] = new Node(rx, ry);
								move[2] = new Node(cnt.x+1, 0);

								v[lx][ly] = true;
								v[rx][ry] = true;

								q.offer(move);
							}
						}
					}
					break;
				case 2:
					if(isIn(lx, ly) && !v[lx][ly] && board[lx][ly] == 0) {
						Node[] move = new Node[3];
						move[0] = new Node(lx, ly);
						move[1] = new Node(rx, ry);
						move[2] = new Node(cnt.x+1, 0);

						v[lx][ly] = true;

						q.offer(move);
					}
					break;
				case 3:
					if(isIn(rx, ry) && board[rx][ry] == 0) {
						Node[] move = new Node[3];
						move[0] = new Node(lx, ly);
						move[1] = new Node(rx, ry);
						move[2] = new Node(cnt.x+1, 0);

						q.offer(move);
					}
					break;
				}

				// 회전

			}
		}
	}

	private static boolean isArrived(int x, int y) {
		return x == 1 && y == 2;
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

class Node {
	int x, y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
