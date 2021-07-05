package PG_�ִ��ٸ��ó���;

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
		
		// �� ��ǥ���� ���� ū ���� ã�� 2���� �迭�� ��, ���� ũ��� �����Ѵ�.
		for(int i = 0; i < N; i++) {
			M = Math.max(M, x[i]);
			M = Math.max(M, y[i]);
		}
		
		// �� ���� �ε����� ������ �࿡ �����ϴ� ���� ���̸� ������ ���� �迭�� �����Ѵ�.
		// �� ���� ���� ū ���� ã�ƾ��ϹǷ� �ּڰ����� �ʱ�ȭ�Ѵ�.
		lines = new int[M];
		Arrays.fill(lines, Integer.MIN_VALUE);
		
		// ��� ���� ���ؼ� �ڽŰ� ���� �࿡ �ִ� ���� ã��, ���� ���̸� ���Ѵ�.
		for(int i = 0; i < N; i++) {
			int curX = y[i];
			int curY = x[i];
			int length = Integer.MIN_VALUE;
			
			for(int j = 0; j < N; j++) {
				int nextX = y[j];
				int nextY = x[j];
				
				// ���� i��° ������ ������ ���� ���̸� ���Ѵ�.
				if(i != j && curX == nextX) {
					length = Math.max(length, Math.abs(curY - nextY));
				}
			}
			
			// ���� ���̰� �ʱⰪ�� ���ٸ� ���� ���� �� ���� ������ �Ǵ��Ѵ�.
			// ������ ���� ��ٸ����� ã�ƾ��ϹǷ� �� �࿡�� ���� �� ���� ��󳽴�.
			if(length != Integer.MIN_VALUE) {
				lines[curX] = Math.max(lines[curX], length);
			}
		}
		
		// �� ���� ����(����, ����)�� ArrayList�� �����Ѵ�.
		for(int i = 0; i < M; i++) {
			if(lines[i] != Integer.MIN_VALUE) {
				list.add(new Node(lines[i], i));
			}
		}
		
		// ���� ���� ������ ���Ѵٸ� 0�� return�Ѵ�.
		if(list.size() == 0) {
			System.out.println(0);
		} else {
			v = new boolean[list.size()];
			solve(0, 0);
			
			System.out.println(answer*2);
		}
	}
	
	// ��� �� �߿��� ������ �� 2���� ��� ���̸� ����Ѵ�.
	private static void solve(int depth, int idx) {
		if(depth == 2) {
			
			// ���� �� �� 2���� ���̸� ���ϰ� �ִ񰪰� �� �� �����Ѵ�.
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