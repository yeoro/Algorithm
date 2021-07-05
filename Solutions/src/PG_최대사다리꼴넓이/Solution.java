package PG_최대사다리꼴넓이;

import java.io.*;
import java.util.*;

class Solution {
	
	static class Node {
		int w, h;

		public Node(int w, int h) {
			this.w = w;
			this.h = h;
		}
	}
	static ArrayList<Node> list = new ArrayList<Node>();
	static ArrayList<Node> temp = new ArrayList<Node>();
	static int[] lines;
	static boolean[] v;
	static int N, M = Integer.MIN_VALUE, answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		int[] x = {2, 3, 4, 4, 7, 6, 3, 9, 9, 6, 5, 8, 6, 4},
			  y = {5, 9, 5, 1, 3, 1, 3, 3, 8, 7, 10, 9, 9, 8};
		
		int N = x.length;
		
		// 각 좌표에서 가장 큰 값을 찾고 2차원 배열의 행, 열의 크기로 생각한다.
		for(int i = 0; i < N; i++) {
			M = Math.max(M, x[i]);
			M = Math.max(M, y[i]);
		}
		
		// 각 행을 인덱스로 가지고 행에 존재하는 변의 길이를 값으로 갖는 배열을 선언한다.
		// 각 행의 가장 큰 변을 찾아야하므로 최솟값으로 초기화한다.
		lines = new int[M];
		Arrays.fill(lines, Integer.MIN_VALUE);
		
		// 모든 점에 대해서 자신과 같은 행에 있는 점을 찾고, 변의 길이를 구한다.
		for(int i = 0; i < N; i++) {
			int curX = y[i];
			int curY = x[i];
			int length = Integer.MIN_VALUE;
			
			for(int j = 0; j < N; j++) {
				int nextX = y[j];
				int nextY = x[j];
				
				// 현재 i번째 점에서 가능한 변의 길이를 구한다.
				if(i != j && curX == nextX) {
					length = Math.max(length, Math.abs(curY - nextY));
				}
			}
			
			// 변의 길이가 초기값과 같다면 변을 만들 수 없는 것으로 판단한다.
			// 면적이 넓은 사다리꼴을 찾아야하므로 각 행에서 가장 긴 변을 골라낸다.
			if(length != Integer.MIN_VALUE) {
				lines[curX] = Math.max(lines[curX], length);
			}
		}
		
		// 각 변의 정보(넓이, 높이)를 ArrayList에 저장한다.
		for(int i = 0; i < M; i++) {
			if(lines[i] != Integer.MIN_VALUE) {
				list.add(new Node(lines[i], i));
			}
		}
		
		// 만약 변을 만들지 못한다면 0을 return한다.
		if(list.size() == 0) {
			System.out.println(0);
		} else {
			v = new boolean[list.size()];
			solve(0, 0);
			
			System.out.println(answer*2);
		}
	}
	
	// 모든 변 중에서 임의의 변 2개를 골라 넓이를 계산한다.
	private static void solve(int depth, int idx) {
		if(depth == 2) {
			
			// 현재 고른 변 2개의 넓이를 구하고 최댓값과 비교 후 갱신한다.
			answer = Math.max(answer, calArea());
			return;
		}
		
		for(int i = idx; i < list.size(); i++) {
			if(!v[i]) {
				v[i] = true;
				temp.add(list.get(i));
				solve(depth+1, i+1);
				temp.remove(temp.size()-1);
				v[i] = false;
			}
		}
	}
	
	private static int calArea() {
		int w1 = temp.get(0).w;
		int w2 = temp.get(1).w;
		
		int h = Math.abs(temp.get(0).h - temp.get(1).h);
		
		return (w1 + w2) * h / 2;
	}
}