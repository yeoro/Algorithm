package BOJ_01963_소수경로;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node {
		int num, cnt;

		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	static boolean[] v;
	static int start, end, min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			
			v = new boolean[10000];
			
			if(start == end) {
				System.out.println(0);
			} else {
				solve();
				
				System.out.println(min);
			}
		}
		
		br.close();
	}
	
	private static void solve() {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(start, 0));
		v[start] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			String num = Integer.toString(cur.num);
			
			if(cur.num == end) {
				min = Math.min(min, cur.cnt);
				continue;
			}
			
			for(int i = 0; i < num.length(); i++) {
				int change = Integer.parseInt(num.charAt(i)+"");
				StringBuilder sb = new StringBuilder(num);
				
				for(int j = 0; j <= 9; j++) {
					if(change != j) {
						if(i == 0 && j == 0) {
							continue;
						}
						
						sb.setCharAt(i, Character.forDigit(j, 10));
						
						int next = Integer.parseInt(sb.toString());
						
						if(!isPrime(next) && !v[next]) {
							v[next] = true;
									 
							q.offer(new Node(next, cur.cnt+1));
						}
					}
				}
			}
		}
	}
	
	private static boolean isPrime(int x) {
		for(int i = 2; i <= Math.sqrt(x); i++) {
			if(x % i == 0) {
				return true;
			}
		}
		
		return false;
	}
}