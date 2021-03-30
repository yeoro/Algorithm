package PG_2020KAKAO_괄호변환;

import java.io.*;
import java.util.*;

public class PG_2020KAKAO_괄호변환 {
	
	static String p = "()))((()";
	
	public static void main(String[] args) {
		String answer = solve(p);
		
		System.out.println(answer);
	}
	
	private static String solve(String input) {
		if(input.length() == 0) {
			return "";
		}
		
		int left = 0;
		int right = 0;
		StringBuilder u = new StringBuilder();
		StringBuilder v = new StringBuilder();
		boolean perfect = false;
		
		for(int i = 0, size = input.length(); i < size; i++) {
			char cur = input.charAt(i);
			
			if(cur == '(') {
				left++;
			} else {
				right++;
			}
			
			if(left == right) {
				for(int j = 0; j <= i; j++) {
					u.append(input.charAt(j));
					
					// 균형 잡힌 문자열의 첫 문자가 ( 인 경우는 무조건 올바른 문자열
					if(input.charAt(0) == '(') {
						perfect = true;
					}
				}
				
				for(int j = i+1; j < size; j++) {
					v.append(input.charAt(j));
				}
				
				break;
			}
		}
		
		if(perfect) {
			return u.toString() + solve(v.toString());
		} else {
			u = new StringBuilder(u.substring(1, u.length()-1));
			
			for(int i = 0, size = u.length(); i < size; i++) {
				if(u.charAt(i) == '(') {
					u.setCharAt(i, ')');
				} else {
					u.setCharAt(i, '(');
				}
			}
			
			return "(" + solve(v.toString()) + ")" + u.toString();
		}
	}
}

