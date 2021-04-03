package PG_2021īī��Ŀ�ӽ�_�ִ����ǰ;

import java.io.*;
import java.util.*;

public class PG_2021īī��Ŀ�ӽ�_�ִ����ǰ {
	
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
				
				// ���� �κ� ������ �ʿ��� ��ǰ�� �������� ���ϸ� �Ѿ
				if(needs[i][j] == 1) {
					if(!combList.contains(j)) {
						continue loop;
					}
				}
			}
			
			// ���� �κ� ������ ����ǰ�� ���� �� �ִٸ� ���� ����
			cnt++;
		}
		
		// ������ ����ǰ ������ �ִ񰪰� �� �� �ٲ�
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

