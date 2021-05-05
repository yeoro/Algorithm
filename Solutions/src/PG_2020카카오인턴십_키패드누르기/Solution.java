package PG_2020카카오인턴십_키패드누르기;

import java.io.*;
import java.util.*;

class Solution {

	static class Num {
		int x, y;

		public Num(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		int[] numbers = {2, 5, 8, 0};
		String hand = "right";
		String answer = "";
		
		StringBuilder sb = new StringBuilder();
		Num[] n = new Num[12];
		int[] hands = {10, 11};
		
		n[1] = new Num(0, 0);
		n[2] = new Num(0, 1);
		n[3] = new Num(0, 2);
		n[4] = new Num(1, 0);
		n[5] = new Num(1, 1);
		n[6] = new Num(1, 2);
		n[7] = new Num(2, 0);
		n[8] = new Num(2, 1);
		n[9] = new Num(2, 2);
		n[10] = new Num(3, 0);
		n[0] = new Num(3, 1);
		n[11] = new Num(3, 2);
		
		for(int i = 0, size = numbers.length; i < size; i++) {
			int cur = numbers[i];
			
			if(cur == 1 || cur == 4 || cur == 7) {
				sb.append("L");
				hands[0] = cur;
			} else if (cur == 3 || cur == 6 || cur == 9) {
				sb.append("R");
				hands[1] = cur;
			} else {
				int lDis = Math.abs(n[hands[0]].x - n[cur].x) + Math.abs(n[hands[0]].y - n[cur].y);
				int rDis = Math.abs(n[hands[1]].x - n[cur].x) + Math.abs(n[hands[1]].y - n[cur].y);
				
				if(lDis > rDis) {
					sb.append("R");
					hands[1] = cur;
				} else if (lDis < rDis) {
					sb.append("L");
					hands[0] = cur;
				} else {
					if(hand.equals("right")) {
						sb.append("R");
						hands[1] = cur;
					} else {
						sb.append("L");
						hands[0] = cur;
					}
				}
			}
			
		}
		
		answer = sb.toString();
		
		System.out.println(answer);
	}
}

