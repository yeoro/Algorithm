package PG_2020카카오인턴십_수식최대화;

import java.io.*;
import java.util.*;

class Solution {
	
	static ArrayList<Character> ops = new ArrayList<Character>();
	static ArrayList<Character> comb = new ArrayList<Character>();
	static ArrayList<Character> opList = new ArrayList<Character>();
	static ArrayList<Long> numList = new ArrayList<Long>();
	static long max = Long.MIN_VALUE;
	
	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		long answer = 0;
		
		if(expression.contains("-")) ops.add('-');
		if(expression.contains("+")) ops.add('+');
		if(expression.contains("*")) ops.add('*');
		
		for(int i = 0, length = expression.length(); i < length; i++) {
			if(isOp(expression.charAt(i))) {
				opList.add(expression.charAt(i));
			}
		}
		
		String[] temp = expression.split("[*+-]");
		for(int i = 0, size = temp.length; i < size; i++) {
			numList.add(Long.parseLong(temp[i]));
		}
		
		makeOrder(0, ops.size());
		
		answer = max;
		
		System.out.println(answer);
	}
	
	private static boolean isOp(char c) {
		return c == '-' || c == '+' || c == '*';
	}
	
	private static void makeOrder(int depth, int N) {
		if(depth == N) {
			solve();
			return;
		}
		
		for(int i = 0, size = ops.size(); i < size; i++) {
			if(!comb.contains(ops.get(i))) {
				comb.add(ops.get(i));
				makeOrder(depth+1, N);
				comb.remove(comb.size()-1);
			}
		}
	}
	
	private static void solve() {
		ArrayList<Character> combTemp = new ArrayList<Character>(comb);
		ArrayList<Character> opTemp = new ArrayList<Character>(opList);
		ArrayList<Long> numTemp = new ArrayList<Long>(numList);
		
		for(int i = 0; i < combTemp.size(); i++) {
			char curOp = combTemp.get(i);
			
			for(int j = 0; j < opTemp.size(); j++) {
				if(curOp == opTemp.get(j)) {
					long num1 = numTemp.get(j);
					long num2 = numTemp.get(j+1);
					
					long res = cal(num1, num2, curOp);
					
					opTemp.remove(j);
					numTemp.set(j, res);
					numTemp.remove(j+1);
					
					j--;
				}
			}
		}
		
		max = Math.max(max, Math.abs(numTemp.get(0)));
	}
	
	private static long cal(long num1, long num2, char op) {
		long res = 0;
		
		switch(op) {
		case '-':
			res = num1 - num2;
			break;
		case '+':
			res = num1 + num2;
			break;
		case '*':
			res = num1 * num2;
			break;
		}
		
		return res;
	}
}

