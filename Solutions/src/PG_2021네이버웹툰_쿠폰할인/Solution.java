package PG_2021³×ÀÌ¹öÀ¥Å÷_ÄíÆùÇÒÀÎ;

import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		int[] prices = {13000, 88000, 10000};
		int[] discounts = {30, 20};
		int answer = 0;
		
		Integer[] p = new Integer[prices.length];
		Integer[] d = new Integer[discounts.length];
		
		int size = Math.min(prices.length, discounts.length);
		
		for(int i = 0; i < prices.length; i++) {
			p[i] = prices[i];
		}
		
		for(int i = 0; i < discounts.length; i++) {
			d[i] = discounts[i];
		}
		
		Arrays.sort(p, Collections.reverseOrder());
		Arrays.sort(d, Collections.reverseOrder());
		
		for(int i = 0; i < size; i++) {
			p[i] = (int) (p[i] * (100 - d[i]) / 100.0);
		}
		
		for(int i : p) {
			answer += i;
		}
		
		System.out.println(answer);
	}
}

