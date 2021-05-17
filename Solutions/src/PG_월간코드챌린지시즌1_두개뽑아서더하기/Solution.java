package PG_월간코드챌린지시즌1_두개뽑아서더하기;

import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		int[] numbers = {2,1,3,4,1};
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < numbers.length; i++) {
			int cur = numbers[i];
			
			for(int j = i+1; j < numbers.length; j++) {
				int next = numbers[j];
				
				set.add(cur+next);
			}
		}
		
		Integer[] answer = set.toArray(new Integer[set.size()]);
		
		Arrays.sort(answer);
		
		System.out.println(Arrays.toString(answer));
	}
}

