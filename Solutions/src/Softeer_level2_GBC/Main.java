package Softeer_level2_GBC;

import java.util.*;
import java.io.*;

public class Main {
	
	static int[] standard = new int[101];
	static int[] speed = new int[101];
	static int N, M;
	
	public static void main  (String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int cur = -1;
		int next = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int zone = Integer.parseInt(st.nextToken());
			int zSpeed = Integer.parseInt(st.nextToken());
			
			cur = next+1;
			next += zone;
			
			for(int j = cur; j <= next; j++) {
				standard[j] = zSpeed;
			}
			
			System.out.println(cur + " " + next);
			
		}
		
		System.out.println(Arrays.toString(standard));
		
	}
}