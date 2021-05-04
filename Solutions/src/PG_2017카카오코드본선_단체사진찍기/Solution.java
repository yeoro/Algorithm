package PG_2017카카오코드본선_단체사진찍기;

import java.io.*;
import java.util.*;

class Solution {
	
	static HashMap<String, Integer> hm = new HashMap<String, Integer>();
    static int[] position;
    static String[] datas;
	static boolean[] v;
	static int answer;
	
	public static void main(String[] args) {
		String[] data = {"N~F=0", "R~T>2"};
		
		datas = data;
		answer = 0;
		v = new boolean[8];
		position = new int[8];
		
		hm.put("A", 0);
		hm.put("C", 1);
		hm.put("F", 2);
		hm.put("J", 3);
		hm.put("M", 4);
		hm.put("N", 5);
		hm.put("R", 6);
		hm.put("T", 7);
		
		stand(0);
		
		System.out.println(answer);
	}
	
	private static void stand(int depth) {
		if(depth == 8) {
			
			if(check()) {
				answer++;
			}
			
			return;
		}
		
		for(int i = 0; i < 8; i++) {
			if(!v[i]) {
				v[i] = true;
				position[depth] = i;
				stand(depth+1);
				v[i] = false;
			}
		}
	}
	
	private static boolean check() {
		for(String s : datas) {
			
			int n1 = position[hm.get(s.charAt(0)+"")];
			int n2 = position[hm.get(s.charAt(2)+"")];
			char op = s.charAt(3);
			int dis = s.charAt(4) - '0';
			
			switch(op) {
			case '=':
				if(Math.abs(n1 - n2)-1 != dis) {
					return false;
				}
				break;
			case '>':
				if(Math.abs(n1 - n2)-1 <= dis) {
					return false;
				}
				break;
			case '<':
				if(Math.abs(n1 - n2)-1 >= dis) {
					return false;
				}
				break;
			}
		}
		
		return true;
	}
}
