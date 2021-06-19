package Codility_01_이메일만들기;

import java.io.*;
import java.sql.Array;
import java.util.*;

class Solution {
	
	static HashMap<String, Integer> hm = new HashMap<String, Integer>();
	static ArrayList<String> ids = new ArrayList<String>();
	
	public static void main(String[] args) {
		String s = "John Doe; "
				+ "Peter Benjamin Parker; "
				+ "Mary Jane Watson-Parker; "
				+ "John Elvis Doe; "
				+ "John Evan Doe; "
				+ "Jane Doe; "
				+ "Peter Brian Parker";
		String C = "Example";
		
		StringBuilder answer = new StringBuilder();
		String company = C.toLowerCase();
		String[] names = s.split("; ");
		
		for(String e : names) {
			String[] cur = e.split(" ");
			
			String input = setId(cur);
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(e)
			  .append(" <")
			  .append(input);
			
			if(hm.get(input) != 1) {
				sb.append(hm.get(input));
			}
			
			sb.append("@")
			  .append(company)
			  .append(".com>");
			
			ids.add(sb.toString());
		}
		
		for(int i = 0; i < ids.size(); i++) {
			if(i == ids.size()-1) {
				answer.append(ids.get(i));
			} else {
				answer.append(ids.get(i) + "; ");
			}
		}

		System.out.println(answer.toString());
	}
	
	private static String setId(String[] cur) {
		StringBuilder input = new StringBuilder();
		StringBuilder first = new StringBuilder(cur[0]);
		StringBuilder last = new StringBuilder(cur[cur.length-1]);
		
		// 성에서 하이픈 제거
		if(last.indexOf("-") >= 0) {
			last = last.deleteCharAt(last.indexOf("-"));
		}
		
		String lastInput = "";
		// 성은 8글자 까지만
		if(last.length() > 8) {
			lastInput = last.substring(0, 8);
		} else {
			lastInput = last.toString();
		}
		
		input.append(first.toString().toLowerCase())
			 .append('.')
			 .append(lastInput.toLowerCase());
		
		hm.put(input.toString(), hm.getOrDefault(input.toString(), 0)+1);
		
		return input.toString();
	}
}

