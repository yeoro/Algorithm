package PG_2021카카오인턴십_표관리프로그램;

import java.io.*;
import java.util.*;

class Solution {
	
	
	public static void main(String[] args) {
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		int n = 8;
		int k = 2;
		String answer = "";
		
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> nums = new LinkedList<Integer>();
		Stack<int[]> deleteNums = new Stack<int[]>();
		
		for(int i = 0; i < n; i++) {
			nums.offer(i);
		}
		
		for(int i = 0; i < cmd.length; i++) {
			StringTokenizer st = new StringTokenizer(cmd[i], " ");
			
			String op = st.nextToken();
			
			switch(op) {
			case "U":
				k -= Integer.parseInt(st.nextToken());
				break;
			case "D":
				k += Integer.parseInt(st.nextToken());
				break;
			case "C":
				deleteNums.push(new int[] {k, nums.get(k)});
				nums.remove(k);
				
				if(k == nums.size()) {
					k--;
				}
				
				break;
			case "Z":
				int[] pop = deleteNums.pop();
				
				nums.add(pop[0], pop[1]);
				
				if(pop[0] <= k) {
					k++;
				}
				
				break;
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(nums.contains(i)) {
				sb.append('O');
			} else {
				sb.append('X');
			}
		}
		
		answer = sb.toString();
		
		System.out.println(answer);
	}
}

