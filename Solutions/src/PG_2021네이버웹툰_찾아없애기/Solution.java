package PG_2021네이버웹툰_찾아없애기;

import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		String s = "aaaaabbbbb";
		String t = "ab";
		
		int result = 0;
		int idx = 0;
		int length = t.length();
		
		while(true) {
			if(idx > s.length()-length) {
				break;
			}
			
			String target = s.substring(idx, idx+length);
			
			if(target.equals(t)) {
				StringBuilder temp = new StringBuilder();
				
				temp.append(s.substring(0, idx))
					.append(s.substring(idx+length));
				
				s = temp.toString();
				
				result++;
				idx--;
			} else {
				idx++;
			}
		}
		
		System.out.println(result);
	}
}