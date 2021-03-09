package BOJ_16637_괄호추가하기;

import java.io.*;
import java.util.*;

public class BOJ_16637_괄호추가하기 {
	
	static ArrayList<Integer> nums = new ArrayList<Integer>();
	static ArrayList<Character> ops = new ArrayList<Character>();
	static int N, max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(isNum(c)) {
				nums.add(Integer.parseInt(c + ""));
			} else {
				ops.add(c);
			}
		}
		
		solve(nums.get(0), 0);
		
		bw.write(max + "\n");
		
		br.close();
		bw.flush();
	}
	
	private static void solve(int res, int opIdx) {
		if(opIdx >= ops.size()) {
			max = Math.max(res, max);
			return;
		}
		
		// 괄호 없이 연산 진행
		int result = cal(res, nums.get(opIdx+1), ops.get(opIdx));
		solve(result, opIdx+1);
		
		// 다음 진행될 연산을 먼저 한 후 연산 진행 - 괄호 존재
		if(opIdx+1 < ops.size()) {
			result = cal(nums.get(opIdx+1), nums.get(opIdx+2), ops.get(opIdx+1));
			solve(cal(res, result, ops.get(opIdx)), opIdx+2);
		}
	}
	
	private static int cal(int a, int b, char c) {
		switch(c) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		}
		return 0;
	}
	
	private static boolean isNum(char c) {
		return c >= 48 && c <= 57;
	}
}

