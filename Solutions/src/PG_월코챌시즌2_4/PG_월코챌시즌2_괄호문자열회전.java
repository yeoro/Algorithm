package PG_¿ùÄÚÃ§½ÃÁğ2_4;

import java.io.*;
import java.util.*;

public class PG_¿ùÄÚÃ§½ÃÁğ2_°ıÈ£¹®ÀÚ¿­È¸Àü {
	
	static int[] set, rank;
	static int cnt;
	
	public static void main(String[] args) {
		
		int[] a = {-5,0,2,1,2};
		int[][] edges = {{0, 1}, {3, 4}, {2, 3}, {0, 3}};
		
		rank = new int[a.length];
		set = new int[a.length];
		
		for(int i = 0; i < a.length; i++) {
			set[i] = i;
			rank[i] = 0;
		}
		
		for(int i = 0, size = edges.length; i < size; i++) {
			union(edges[i][0], edges[i][1], a);
		}
		
		if(a[0] != 0) {
			System.out.println(-1);
		} else {
			System.out.println(cnt);
		}
	}
	
	private static void union(int x, int y, int[] a) {
		int xr = find(x);
		int yr = find(y);
		
		if(xr == yr) {
			return;
		}
		
		if(rank[xr] < rank[yr]) {
			if(a[xr] != 0) {
				a[yr] += a[xr];
				cnt += a[xr];
				a[xr] = 0;
			}
			
			set[xr] = yr;
		} else {
			if(a[yr] != 0) {
				a[xr] += a[yr];
				cnt += a[yr];
				a[yr] = 0;
			}
			
			set[yr] = xr;
		}
		
		if(rank[xr] == rank[yr]) {
			rank[xr]++;
		}
	}
	
	private static int find(int x) {
		if(x == set[x]) {
			return x;
		}
		
		return set[x] = find(set[x]);
	}
}

