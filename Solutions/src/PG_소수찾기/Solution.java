package PG_소수찾기;

import java.io.*;
import java.util.*;

class Solution {

	static ArrayList<Integer> comb = new ArrayList<Integer>();
	static int[] nums;
	static boolean[] v, vPrime;
	static int size, answer;

	public static void main(String[] args) {
		String numbers = "17";

		size = numbers.length();
		nums = new int[size];
		v = new boolean[size];
		vPrime = new boolean[10000000];

		for(int i = 0; i < size; i++) {
			nums[i] = Integer.parseInt(numbers.charAt(i)+""); 
		}

		solve(0);

		System.out.println(answer);
	}

	private static void solve(int depth) {
		if(depth > size) {
			return;
		}

		if(comb.size() > 0) {
			if(chkNumber()) {
				answer++;
			}
		}

		for(int i = 0; i < size; i++) {
			if(!v[i]) {
				v[i] = true;
				comb.add(nums[i]);
				solve(depth+1);
				comb.remove(comb.size()-1);
				v[i] = false;
			}
		}
	}

	private static boolean chkNumber() {
		StringBuilder sb = new StringBuilder();
		for(int i : comb) {
			sb.append(i);
		}

		int cur = Integer.parseInt(sb.toString());

		if(!vPrime[cur] && isPrime(cur)) {
			vPrime[cur] = true;
			return true;
		}

		return false;
	}

	private static boolean isPrime(int n) {
		if(n < 2) {
			return false;
		}

		if(n == 2) {
			return true;
		}

		for(int i = 3; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				return false;
			}
		}

		return true;
	}
}