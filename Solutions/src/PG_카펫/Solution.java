package PG_카펫;

import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;

		int[] answer = new int[2];
		ArrayList<Integer> list = new ArrayList<Integer>();

		int area = brown + yellow;

		// 가로, 세로 후보인 약수 저장
		for(int i = 1; i <= area; i++) {
			if(area % i == 0) {
				list.add(i);
			}
		}

		// 정답 걸러내기
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