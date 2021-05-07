package PG_야근지수;

import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		int[] works = {4, 3, 3};
		int n = 4;
		long answer = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i = 0; i < works.length; i++) {
			pq.offer(works[i]);
		}
		
		if(Arrays.stream(works).sum() < n) {
			answer = 0;
		} else {
			while(n-- > 0) {
				int cur = pq.poll();
				pq.offer(--cur);
			}
			
			while(!pq.isEmpty()) {
				int cur = pq.poll();
				answer += cur*cur;
			}
		}
		
		System.out.println(answer);
	}
}