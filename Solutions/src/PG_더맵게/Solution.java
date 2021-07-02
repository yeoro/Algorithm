package PG_´õ¸Ê°Ô;

import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for(int i = 0; i < scoville.length; i++) {
			pq.add(scoville[i]);
		}

		loop: while(true) {
			boolean chk = false;
			Iterator<Integer> iter = pq.iterator();

			while(iter.hasNext()) {
				int cur = iter.next();

				if(cur < K) {
					chk = true;
					if(pq.size() == 1) {
						answer = -1;
						break loop;
					}
					break;
				}
			}

			if(chk) {
				int num1 = pq.poll();
				int num2 = pq.poll();

				pq.add((num2*2)+num1);

				answer++;
			} else {
				break;
			}
		}
		
		System.out.println(answer);
	}
}

