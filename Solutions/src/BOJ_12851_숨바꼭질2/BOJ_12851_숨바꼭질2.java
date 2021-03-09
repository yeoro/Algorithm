package BOJ_12851_¼û¹Ù²ÀÁú2;

import java.io.*;
import java.util.*;

public class BOJ_12851_¼û¹Ù²ÀÁú2 {
	
	static boolean[] v;
	static int N, K, cnt, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		v = new boolean[100001];
		
		bfs();
		
		System.out.println(min + "\n" + cnt);
		sc.close();
	}
	
	private static void bfs() {
		Queue<Subin> q = new LinkedList<Subin>();
		q.add(new Subin(N, 0));
		v[N] = true;
		
		while(!q.isEmpty()) {
			Subin s = q.poll();
			int pos = s.x;
			int time = s.time;
			
			v[pos] = true;
			
			if(pos == K) {
				min = Math.min(time, min);
				
				if(min == time) {
					cnt++;
				}
			}
			
			if(isIn(pos+1) && !v[pos+1]) {
				q.add(new Subin(pos+1, time+1));
			}
			
			if(isIn(pos-1) && !v[pos-1]) {
				q.add(new Subin(pos-1, time+1));
			}
			
			if(isIn(pos*2) && !v[pos*2]) {
				q.add(new Subin(pos*2, time+1));
			}
		}
	}
	
	private static boolean isIn(int x) {
		return x >= 0 && x <= 100000;
	}
}

class Subin {
	int x, time;

	public Subin(int x, int time) {
		this.x = x;
		this.time = time;
	}
}
