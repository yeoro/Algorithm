package PG_2020카카오인턴십_수식최대화;

import java.io.*;
import java.util.*;

class Solution {
	
	static ArrayList<String> list = new ArrayList<String>();
	static ArrayList<Integer> comb = new ArrayList<Integer>();
	static boolean[] v;
	static int N;
	static StringBuilder sb = new StringBuilder("100-200*300-500+20");
	
	public static void main(String[] args) {
		
		if(sb.toString().contains("-")) {
			list.add("-");
		}
		if(sb.toString().contains("+")) {
			list.add("+");
		}
		if(sb.toString().contains("*")) {
			list.add("*");
		}
		
		N = list.size();
		v = new boolean[list.size()];
		
		System.out.println(sb.indexOf("-"));
		
		go(0);
		
	}
	
	private static void go(int depth) {
		if(depth == N) {
			StringBuilder r = new StringBuilder();
			StringBuilder l = new StringBuilder();
			
			
			for(int i : comb) {
				int rIdx = sb.indexOf(list.get(i));
				int lIdx = sb.indexOf(list.get(i));
				
				// 부호 왼쪽 숫자
				while(lIdx > 0) {
					lIdx--;
					
					char cur = sb.charAt(lIdx);
					if(cur >= '0' && cur <= '9') {
						l.append(cur);
					} else {
						break;
					}
				}
				
				// 부호 오른쪽 숫자
				while(rIdx < sb.length()-1) {
					rIdx++;
					
					char cur = sb.charAt(rIdx);
					if(cur >= '0' && cur <= '9') {
						r.append(cur);
					} else {
						break;
					}
				}
				
				System.out.println(lIdx + " " + rIdx);
				System.out.println(l.reverse().toString() + " " + r.toString());
			}
			
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
}

