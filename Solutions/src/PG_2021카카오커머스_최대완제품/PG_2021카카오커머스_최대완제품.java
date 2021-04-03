package PG_2021카카오커머스_최대완제품;

import java.io.*;
import java.util.*;

public class PG_2021카카오커머스_최대완제품 {
	
	static ArrayList<Integer> combList = new ArrayList<Integer>();
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		int[][] needs = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
		int r = 2;
		
		robotComb(0, r, needs);
		
		int answer = max;
		
		System.out.println(answer);
	}
	
	private static void robotComb(int depth, int r, int[][] needs) {
		if(combList.size() > r) {
			return;
		}

		int cnt = 0;
		
		loop:for(int i = 0, pSize = needs.length; i < pSize; i++) {
			for(int j = 0, nSize = needs[i].length; j < nSize; j++) {
				
				// 현재 로봇 조합이 필요한 부품을 충족하지 못하면 넘어감
				if(needs[i][j] == 1) {
					if(!combList.contains(j)) {
						continue loop;
					}
				}
			}
			
			// 현재 로봇 조합이 완제품을 만들 수 있다면 갯수 증가
			cnt++;
		}
		
		// 가능한 완제품 갯수를 최댓값과 비교 후 바꿈
		max = Math.max(cnt, max);
		
		for(int i = depth; i <= r; i++) {
			if(!combList.contains(i)) {
				combList.add(i);
				robotComb(i+1, r, needs);
				combList.remove(combList.size()-1);
			}
		}
	}
}

