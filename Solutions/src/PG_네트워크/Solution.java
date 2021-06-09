package PG_네트워크;

import java.io.*;
import java.util.*;

class Solution {
	
	static LinkedList<Integer>[] adj;
	static boolean[] v;
	
	public static void main(String[] args) {
		int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
		int n = 3;
		
		int answer = 0;
		adj = new LinkedList[n];
		v = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(computers[i][j] == 1 && i != j) {
					adj[i].add(j);
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(!v[i]) {
				v[i] = true;
				solve(i);
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	private static void solve(int node) {
		for(int next : adj[node]) {
			if(!v[next]) {
				v[next] = true;
				solve(next);
			}
		}
	}
}