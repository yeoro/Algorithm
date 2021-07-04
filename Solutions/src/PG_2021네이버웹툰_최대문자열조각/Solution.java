package PG_2021네이버웹툰_최대문자열조각;

import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		String s = "abcxyqwertyxyabc";
		
		int n = s.length();
		StringBuilder start = new StringBuilder();
		StringBuilder end = new StringBuilder();
		LinkedList<String> list = new LinkedList<String>();
		
		for(int i = 0; i < n/2; i++) {
			if(start.toString().equals("") || !start.toString().equals(end.toString())) {
				start.append(s.charAt(i));
				end.insert(0, s.charAt(n-1-i));
				
				if(start.toString().equals(end.toString())) {
					list.add(list.size()/2, start.toString());
					list.add(list.size()/2+1, end.toString());
					
					start.delete(0, start.length());
					end.delete(0, end.length());
				}
			}
		}
		
		if(start.length() > 0) {
			start.append(end);
			list.add(list.size()/2, start.toString());
		}
		
		String[] answer = new String[list.size()];
		
		for(int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		System.out.println(Arrays.toString(answer));
	}
}

