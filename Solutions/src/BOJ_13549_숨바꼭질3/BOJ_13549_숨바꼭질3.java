package BOJ_13549_¼û¹Ù²ÀÁú3;

import java.io.*;
import java.util.*;

public class BOJ_13549_¼û¹Ù²ÀÁú3 {
	
	static boolean[] v = new boolean[100001];
	static int N, K, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		bfs();
		
		System.out.println(min);
		
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
			
			if(pos == K) {
				min = Math.min(min, time);
				continue;
			}
			
			if(isIn(pos*2) && !v[pos*2]) {
				v[pos*2] = true;
				q.add(new Subin(pos*2, time));
			}
			
			if(isIn(pos-1) && !v[pos-1]) {
				v[pos-1] = true;
				q.add(new Subin(pos-1, time+1));
			}
			
			if(isIn(pos+1) && !v[pos+1]) {
				v[pos+1] = true;
				q.add(new Subin(pos+1, time+1));
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


