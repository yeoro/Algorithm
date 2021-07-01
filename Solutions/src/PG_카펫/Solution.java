package PG_ī��;

import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;

		int[] answer = new int[2];
		ArrayList<Integer> list = new ArrayList<Integer>();

		int area = brown + yellow;

		// ����, ���� �ĺ��� ��� ����
		for(int i = 1; i <= area; i++) {
			if(area % i == 0) {
				list.add(i);
			}
		}

		// ���� �ɷ�����
		for(int i = list.size()-1; i >= 0; i--) {
			int w = list.get(i);
			int h = list.get(list.size()-i-1);

			if(w >= h) {
				if((w-2)*(h-2) == yellow) {
					answer[0] = w;
					answer[1] = h;
					break;
				}
			}
		}
		
		System.out.println(Arrays.toString(answer));
	}
}