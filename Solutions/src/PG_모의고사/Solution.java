package PG_모의고사;

import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		int[] answers = {1, 2, 3, 4, 5};
		
		int[] answer = {};
		int[] one = {1, 2, 3, 4, 5},
			  two = {2, 1, 2, 3, 2, 4, 2, 5},
			  three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int[] score = new int[3];
		int N = answers.length;
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int i = 0; i < N; i++) {
			int curAns = answers[i];
			
			if(one[i%5] == curAns) {
				score[0]++;
			}
			
			if(two[i%8] == curAns) {
				score[1]++;
			}
			
			if(three[i%10] == curAns) {
				score[2]++;
			}
		}
		
		for(int i = 0; i < 3; i++) {
			if(!hm.containsKey(score[i])) {
				hm.put(score[i], new ArrayList<Integer>());
			}
			
			hm.get(score[i]).add(i);
		}
		
		Object[] mapKey = hm.keySet().toArray();
		
		Arrays.sort(mapKey, Collections.reverseOrder());
		
		for(Object o : mapKey) {
			int cur = (int) o;
			
			if(cur != 0) {
				answer = new int[hm.get(cur).size()];
				
				for(int i = 0; i < answer.length; i++) {
					answer[i] = hm.get(cur).get(i)+1;
				}
				
				break;
			}
		}
		
		System.out.println(Arrays.toString(answer));
		
	}
}

