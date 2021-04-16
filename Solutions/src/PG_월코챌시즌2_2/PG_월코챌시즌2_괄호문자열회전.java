package PG_����ç����2_2;

import java.io.*;
import java.util.*;

public class PG_����ç����2_��ȣ���ڿ�ȸ�� {
	
	public static void main(String[] args) {
		
		String s = "[](){}";
		
		StringBuilder sb = new StringBuilder(s);
		
		int answer = 0;
		
		for(int i = 0, size = s.length(); i < size-1; i++) {
			if(i == 0 && isRight(sb.toString())) {
				answer++;
				continue;
			}
			
			char temp = sb.charAt(0);
			
			sb.deleteCharAt(0);
			sb.append(temp);
			
			if(sb.charAt(0) == ')' || sb.charAt(0) == '}' || sb.charAt(0) == ']') {
				continue;
			}
			
			if(isRight(sb.toString())) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	private static boolean isRight(String s) {
		boolean check = false;
		
		int small = 0;
		int medium = 0;
		int large = 0;
		
		loop: for(int i = 0, size = s.length(); i < size; i++) {
			switch(s.charAt(i)) {
			case '(':
				if(small < 0) {
					check = false;
					break loop;
				} 
				small++;
				break;
			case ')':
				small--;
				break;
			case '{':
				if(medium < 0) {
					check = false;
					break loop;
				}
				medium++;
				break;
			case '}':
				medium--;
				break;
			case '[':
				if(large < 0) {
					check = false;
					break loop;
				}
				large++;
				break;
			case ']':
				large--;
				break;
			}
		}
		
		if(small == 0 && medium == 0 && large == 0) {
			check = true;
		}
		
		return check;
	}
}

