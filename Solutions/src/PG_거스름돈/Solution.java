package PG_°Å½º¸§µ·;

import java.io.*;
import java.util.*;

class Solution {
	
	static int cnt;
	
	public static void main(String[] args) {
		int[] money = {1, 2, 5};
		int n = 5;
		int answer = 0;
		
		change(0, n);
		
		answer = cnt;
		
		System.out.println(answer);
				
				
	}
	
	private static void change(int sum, int n) {
		if(sum == n) {
			cnt++;
			return;
		}
		
		if(sum+1 <= n) change(sum+1, n);
		if(sum+2 <= n) change(sum+2, n);
		if(sum+5 <= n) change(sum+5, n);
	}
}

