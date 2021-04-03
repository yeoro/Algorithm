package PG_2021데브매칭_회전후최솟값찾기;

import java.io.*;
import java.util.*;

public class PG_2021데브매칭_회전후최솟값찾기 {
	
	static int[][] map, copy;
	static int min;
	
	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		
		int[] answer = new int[queries.length];
		
		map = new int[rows][columns];
		copy = new int[rows][columns];
		
		int idx = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				map[i][j] = ++idx;
			}
		}
		
		for(int i = 0, r = queries.length; i < r; i++) {
			min = Integer.MAX_VALUE;
			
			int x1 = queries[i][0]-1;
			int y1 = queries[i][1]-1;
			int x2 = queries[i][2]-1;
			int y2 = queries[i][3]-1;
			
			copyArr(rows, columns);
			
			rotate(x1, y1, x2, y2);
			
			copyOg(rows, columns);
			
			answer[i] = min;
		}
		
		System.out.println(Arrays.toString(answer));
		
	}
	
	private static void rotate(int x1, int y1, int x2, int y2) {
		
		// 상
		for(int i = y1; i < y2; i++) {
			min = Math.min(min, map[x1][i]);
			copy[x1][i+1] = map[x1][i];
		}
		
		// 우
		for(int i = x1; i < x2; i++) {
			min = Math.min(min, map[i][y2]);
			copy[i+1][y2] = map[i][y2];
		}
		
		// 하
		for(int i = y2; i > y1; i--) {
			min = Math.min(min, map[x2][i]);
			copy[x2][i-1] = map[x2][i];
		}
		
		// 좌
		for(int i = x2; i > x1; i--) {
			min = Math.min(min, map[i][y1]);
			copy[i-1][y1] = map[i][y1];
		}
	}
	
	private static void copyArr(int r, int c) {
		for(int i = 0; i < r; i++) {
			System.arraycopy(map[i], 0, copy[i], 0, map[i].length);
		}
	}
	
	private static void copyOg(int r, int c) {
		for(int i = 0; i < r; i++) {
			System.arraycopy(copy[i], 0, map[i], 0, copy[i].length);
		}
	}
}

