package PG_2020카카오인턴십_보석쇼핑;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class Solution {
	
	public static void main(String[] args) {
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA", "SAPPHIRE"};
		int[] answer = new int[2];
		
		HashSet<String> hs = new HashSet<String>();
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		Queue<String> q = new LinkedList<String>();
		int start = 0, end = Integer.MAX_VALUE, idx = 0;
		
		for(int i = 0; i < gems.length; i++) {
			hs.add(gems[i]);
		}
		
		for(int i = 0; i < gems.length; i++) {
			hm.put(gems[i], hm.getOrDefault(gems[i], 0)+1);
		
			q.offer(gems[i]);
			
			while(true) {
				String peek = q.peek();
				
				if(hm.get(peek) > 1) {
					hm.put(peek, hm.get(peek)-1);
					q.poll();
					idx++;
				} else {
					break;
				}
			}
			
			if(hm.size() == hs.size() && end > q.size()) {
				end = q.size();
				start = idx;
			}
		}
		
		answer[0] = start+1;
		answer[1] = start+end;
		
		System.out.println(Arrays.toString(answer));
		
	}
}

