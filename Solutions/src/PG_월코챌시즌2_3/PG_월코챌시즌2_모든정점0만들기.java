package PG_¿ùÄÚÃ§½ÃÁğ2_3;

import java.io.*;
import java.util.*;

public class PG_¿ùÄÚÃ§½ÃÁğ2_¸ğµçÁ¤Á¡0¸¸µé±â {
	
	static LinkedList<Integer>[] adj;
	static boolean[] v;
	static int cnt, sum;
	
	public static void main(String[] args) {
		
		int[] a = {-5,0,2,1,2};
		int[][] edges = {{0, 1}, {3, 4}, {2, 3}, {0, 3}};
		
		int answer = 0;
		
		adj = new LinkedList[a.length];
		v = new boolean[a.length];
		
		for(int i = 0; i < a.length; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < edges.length; i++) {
			adj[edges[i][0]].add(edges[i][1]);
			adj[edges[i][1]].add(edges[i][0]);
		}
		
		sum += a[0];
		v[0] = true;
		solve(0, a);
		System.out.println(sum + " " + cnt);
		
		if(sum != 0) {
			answer = -1;
		}
	}
	
	private static void solve(int node, int[] a) {
		for(int i : adj[node]) {
			if(!v[i]) {
				v[i] = true;
				
				if(a[i] != 0) {
					
					sum += a[i];
					System.out.println(sum + " " + node);
				}
				
				solve(i, a);
			}
		}
	}
}

