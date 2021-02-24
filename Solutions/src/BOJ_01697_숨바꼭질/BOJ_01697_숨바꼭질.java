package BOJ_01697_¼û¹Ù²ÀÁú;

import java.io.*;
import java.util.*;

public class BOJ_01697_¼û¹Ù²ÀÁú {
	
	static boolean[] v;
	static int N, K, cnt = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		v = new boolean[100001];
		v[N] = true;
		
		bfs();
		
		System.out.println(cnt);
		
		sc.close();
	}
	
	private static void bfs() {
		Queue<Subin> q = new LinkedList<Subin>();
		q.add(new Subin(N, 0));
		
		while(!q.isEmpty()) {
			Subin s = q.poll();

			if(s.x == K) {
				cnt = Math.min(cnt, s.time);
				continue;
			}
			
			if(isIn(s.x-1) && !v[s.x-1]) {
				v[s.x-1] = true;
				q.add(new Subin(s.x-1, s.time+1));
			}
				
			if(isIn(s.x+1) && !v[s.x+1]) {
				v[s.x+1] = true;
				q.add(new Subin(s.x+1, s.time+1));
			}
				
			if(isIn(s.x*2) && !v[s.x*2]) {
				v[s.x*2] = true;
				q.add(new Subin(s.x*2, s.time+1));	
			}
		}
	}
	
	private static boolean isIn(int x) {
		return x >= 0 && x < 100001;
	}
}

class Subin {
	int x, time;

	public Subin(int x, int time) {
		this.x = x;
		this.time = time;
	}
}

