package PG_월간코드챌린지시즌2_비트바꾸기;

import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		long[] numbers = {2, 7, 6, 9};
		long[] answer = new long[numbers.length];
		
		for(int i = 0; i < numbers.length; i++) {
			long cur = numbers[i];
			StringBuilder sb = new StringBuilder(Long.toBinaryString(cur));
			
			if(sb.charAt(sb.length()-1) == '0') {
				sb.setCharAt(sb.length()-1, '1');
			} else if(!Long.toBinaryString(cur).contains("0")) {
				sb.setCharAt(0, '0');
				sb.insert(0, '1');
			} else {
				for(int j = sb.length()-1; j >= 0; j--) {
					if(sb.charAt(j) == '0') {
						sb.setCharAt(j, '1');
						sb.setCharAt(j+1, '0');
						break;
					}
				}
			}
			
			answer[i] = Long.parseLong(sb.toString(), 2);
		}
		
		System.out.println(Arrays.toString(answer));
	}
}

