package PG_2017카카오코드본선_단체사진찍기;

import java.io.*;
import java.util.*;

class Solution {
	
	static ArrayList<String> list;
	static String[] friends;
	static boolean[] v;
	static int N, answer;
	
	public static void main(String[] args) {
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
		
		list = new ArrayList<String>();
		answer = 0;
		N = friends.length;
		v = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			v[i] = false;
		}
		
		stand(0, data, friends, n);
		
		
		System.out.println(answer);
	}
	
	private static void stand(int depth, String[] data, String[] friends, int n) {
		if(depth == N) {
			
			int check = 0;
			
			for(String s : data) {
				
				int n1 = list.indexOf(s.charAt(0)+"");
				int n2 = list.indexOf(s.charAt(2)+"");
				char op = s.charAt(3);
				int dis = Integer.parseInt(s.charAt(4)+"");
				
				if(check(n1, n2, op, dis)) {
					check++;
				}
			}
			
			if(check == n) {
				answer++;
			}
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				list.add(friends[i]);
				stand(depth+1, data, friends, n);
				v[i] = false;
				list.remove(list.size()-1);
			}
		}
	}
	
	private static boolean check(int n1, int n2, char op, int dis) {
		boolean res = false;
		
		switch(op) {
		case '=':
			if(Math.abs(n1 - n2) == 1) {
				res = true;
			}
			break;
		case '>':
			if(Math.abs(n1 - n2)-1 > dis) {
				res = true;
			}
			break;
		case '<':
			if(Math.abs(n1 - n2)-1 < dis) {
				res = true;
			}
			break;
		}
		
		return res;
	}
}

