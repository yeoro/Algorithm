package PG_¸Ö¸®¶Ù±â;

import java.io.*;
import java.util.*;

class Solution {
	
	static int[] position;
	static boolean[] v;
	static long answer;
	static int N;
	
	public static void main(String[] args) {
		int n = 4;
		
		N = n;
		
		position = new int[N+1];
		v = new boolean[N+1];
		
		jump(0);
		
		System.out.println(position[N] % 1234567);
	}
	
	private static void jump(int pos) {
		if(pos == N) {
			position[N]++;
			return;
		}
		
		if(isIn(pos+1)) {
			jump(pos+1);
		}
		
		if(isIn(pos+2)) {
			jump(pos+2);
		}
	}
	
	private static boolean isIn(int x) {
		return x > 0 && x <= N;
	}
}

