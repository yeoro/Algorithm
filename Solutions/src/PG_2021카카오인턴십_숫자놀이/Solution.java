package PG_2021카카오인턴십_숫자놀이;

import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		String s = "123";
		int answer = 0;
		
		StringBuilder res = new StringBuilder();
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		
		hm.put(0, "zero");
		hm.put(1, "one");
		hm.put(2, "two");
		hm.put(3, "three");
		hm.put(4, "four");
		hm.put(5, "five");
		hm.put(6, "six");
		hm.put(7, "seven");
		hm.put(8, "eight");
		hm.put(9, "nine");
		
		loop: for(int i = 0; i < s.length(); i++) {
			StringBuilder temp = new StringBuilder();
			
			for(int j = i; j < s.length(); j++) {
				char cur = s.charAt(j);
				
				if(cur < '0' || cur > '9') {
					temp.append(cur);
					if(hm.containsValue(temp.toString())) {
						for(Integer num : hm.keySet()) {
							if(hm.get(num).equals(temp.toString())) {
								res.append(num);
							}
						}
						i = j;
						continue loop;
					}
				} else {
					res.append(cur);
					continue loop;
				}
			}
		}
		
		answer = Integer.parseInt(res.toString());
		
		System.out.println(answer);
	}
}

