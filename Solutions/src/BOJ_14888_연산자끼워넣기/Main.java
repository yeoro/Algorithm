package BOJ_14888_연산자끼워넣기;

import java.io.*;
import java.util.*;

class Main {
	
	static ArrayList<Integer> nums = new ArrayList<Integer>();
	static ArrayList<Character> ops = new ArrayList<Character>();
	static ArrayList<Character> comb = new ArrayList<Character>();
	static boolean[] v;
	static int N, M, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		
		String[] input = br.readLine().split(" ");
		
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < Integer.parseInt(input[i]); j++) {
				switch(i) {
				case 0:
					ops.add('+');
					break;
				case 1:
					ops.add('-');
					break;
				case 2:
					ops.add('*');
					break;
				case 3:
					ops.add('/');
					break;
				}
			}
		}
		
		M = ops.size();
		v = new boolean[M];
		
		solve(0);
		
		System.out.println(max);
		System.out.println(min);
		
		br.close();
	}
	
	private static void solve(int depth) {
		if(depth == M) {
			Deque<Integer> dq = new LinkedList<Integer>(nums);
			
			for(int i = 0; i < comb.size(); i++) {
				char op = comb.get(i);
				int n1 = dq.pollFirst();
				int n2 = dq.pollFirst();
				
				dq.addFirst(cal(op, n1, n2));
			}
			
			int res = dq.poll();
			
			max = Math.max(res, max);
			min = Math.min(res, min);
			
			return;
		}
		
		for(int i = 0; i < ops.size(); i++) {
			if(!v[i]) {
				v[i] = true;
				comb.add(ops.get(i));
				solve(depth+1);
				v[i] = false;
				comb.remove(comb.size()-1);
			}
		}
	}
	
	private static int cal(char op, int n1, int n2) {
		switch(op) {
		case '+':
			return n1 + n2;
		case '-':
			return n1 - n2;
		case '*':
			return n1 * n2;
		case '/':
			return n1 / n2;
		}
		
		return 0;
	}
}

