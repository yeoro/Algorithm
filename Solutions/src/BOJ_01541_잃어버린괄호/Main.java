package BOJ_01541_ÀÒ¾î¹ö¸°°ýÈ£;

import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] arr = input.split("[+-]", -1);
		
		ArrayList<String> nums = new ArrayList<String>(Arrays.asList(arr));
		ArrayList<Character> ops = new ArrayList<Character>();
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '-' || input.charAt(i) == '+') {
				ops.add(input.charAt(i));
			}
		}
		
		for(int i = 0; i < ops.size(); i++) {
			if(ops.get(i) == '+') {
				int n1 = Integer.parseInt(nums.get(i));
				int n2 = Integer.parseInt(nums.get(i+1));
				
				nums.remove(i);
				nums.remove(i);
				nums.add(i, Integer.toString(n1+n2));
				
				ops.remove(i);
				--i;
			}
		}
		int res = Integer.parseInt(nums.get(0));
		
		for(int i = 1; i < nums.size(); i++) {
			res -= Integer.parseInt(nums.get(i));
		}
		
		System.out.println(res);
		
		br.close();
	}
}

