package BOJ_06603_·Î¶Ç;

import java.io.*;
import java.util.*;

class Main {
	
	static ArrayList<Integer> list;
	static int[] nums;
	static boolean[] v;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			
			if(N == 0) {
				break;
			}
			
			list = new ArrayList<Integer>();
			nums = new int[N];
			v = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			choice(0, 0);
			
			System.out.println();
		}
		
		br.close();
	}
	
	private static void choice(int depth, int idx) {
		if(depth == 6) {
			for(int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
			
			return;
		}
		
		for(int i = idx; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				list.add(nums[i]);
				choice(depth+1, i+1);
				v[i] = false;
				list.remove(list.size()-1);
			}
		}
	}
}

