package PG_¸Ö¸®¶Ù±â;

import java.io.*;
import java.util.*;

class Solution {
	
	static long[] position;
	
	public static void main(String[] args) {
		int n = 4;
		
		position = new long[n+1];
		
		position[1] = 1;
		
		if(n > 1) {
			position[2] = 2;
		}
		
		for(int i = 3; i <= n; i++) {
			position[i] = (position[i-1] + position[i-2]) % 1234567;
		}
		
		System.out.println(position[n]);
	}
}

