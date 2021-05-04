package PG_2020카카오인턴십_수식최대화;

import java.io.*;
import java.util.*;

class Solution {
	
	static ArrayList<String> list = new ArrayList<String>();
	static ArrayList<Integer> comb = new ArrayList<Integer>();
	static ArrayList<String> num = new ArrayList<String>();
	static String input = "100-200*300-500+20";
	static int N;
	static long max = Long.MIN_VALUE;
	static StringBuilder sb = new StringBuilder("100-200*300-500+20");
	
	public static void main(String[] args) {
		
		if(input.contains("-")) {
			list.add("-");
		}
		if(input.contains("+")) {
			list.add("+");
		}
		if(input.contains("*")) {
			list.add("*");
		}
		
		N = list.size();
		
		go(0);
		
		System.out.println(max);
	}
	
	private static void go(int depth) {
		if(depth == N) {
			System.out.println("---------------------");
			
			StringBuilder temp = new StringBuilder(input);
			
			for(int i : comb) {
				String cur = list.get(i);
				
				for(int j = 0; j < temp.length(); j++) {
					if((temp.charAt(j)+"").equals(cur)) {
						StringBuilder r = new StringBuilder();
						StringBuilder l = new StringBuilder();
						
						int rIdx = j+1;
						int lIdx = j-1;
						
						while(lIdx >= 0) {
							char c = temp.charAt(lIdx);
							if(c >= '0' && c <= '9') {
								l.append(c);
							} else {
								break;
							}
							
							lIdx--;
						}
						
						while(rIdx < temp.length()) {
							char c = temp.charAt(rIdx);
							if(c >= '0' && c <= '9') {
								r.append(c);
							} else {
								break;
							}
							
							rIdx++;
						}
						
						lIdx++;
						
						long res = cal(cur, l.reverse().toString(), r.toString());
						
						
						temp = temp.delete(lIdx, rIdx);
						temp = temp.insert(lIdx, Long.toString(res));
						
						System.out.println(lIdx + " " + rIdx + " " + res + " " + cur);
						System.out.println(l.toString() + " " + r.toString());
						System.out.println(temp.toString());
					}
				}
			}
			
			max = Math.max(max, Long.parseLong(temp.toString()));
			System.out.println("---------------------");
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!comb.contains(i)) {
				comb.add(i);
				go(depth+1);
				comb.remove(comb.size()-1);
			}
		}
	}
	
	private static long cal(String op, String l, String r) {
		long n1 = Long.parseLong(l);
		long n2 = Long.parseLong(r);
		long res = 0;
		
		switch(op) {
		case "*":
			res = n1 * n2;
			break;
		case "+":
			res = n1 + n2;
			break;
		case "-":
			res = n1 - n2;
			break;
		}
		
		return res;
	}
}

