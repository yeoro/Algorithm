package PG_2017카카오코드본선_단체사진찍기;

import java.io.*;
import java.util.*;

class Solution {
	
	static ArrayList<String> list = new ArrayList<String>();
	static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static String[] datas;
	static int answer;
	
	public static void main(String[] args) {
		String[] data = {"N~F=0", "R~T>2"};
		
		datas = data;
		answer = 0;
		
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
			if(!list.contains(friends[i])) {
				list.add(friends[i]);
				stand(depth+1);
				list.remove(list.size()-1);
			}
		}
	}
	
	private static boolean check() {
		for(String s : datas) {
			
			int n1 = list.indexOf(s.charAt(0)+"");
			int n2 = list.indexOf(s.charAt(2)+"");
			char op = s.charAt(3);
			int dis = Integer.parseInt(s.charAt(4)+"");
			
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
