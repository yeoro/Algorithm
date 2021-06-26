package Softeer_level3_스마트물류;

import java.util.*;
import java.io.*;

// 1시간 4분
public class Main
{
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static char[] line;
	static int[] dx = {-1, 1};
	static int N, K, size, max = Integer.MIN_VALUE;

	public static void main  (String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		line = new char[N+1];

		String input = br.readLine();

		for(int i = 0; i < input.length(); i++) {
			line[i+1] = input.charAt(i);

			if(line[i+1] == 'P') {
				list.add(i+1);
			}
		}

		size = list.size();

		solve(0, 0, new boolean[N+1]);

		if(max == Integer.MIN_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(max);
		}

		br.close();
	}

	private static void solve(int depth, int cnt, boolean[] v) {
		if(depth ==  size) {
			max = Math.max(cnt, max);
			return;
		}
		
		boolean[] temp = v;
		int x = list.get(depth);

		for(int k = 1; k <= K; k++) {
			for(int dir = 0; dir < 2; dir++) {
				int nx = x + (dx[dir]*k);
				
				System.out.println("-----------");
				
				if(isIn(nx) && line[nx] == 'H' && !temp[nx]) {
					System.out.println(x + " -> " + nx + " ");
					temp[nx] = true;
					for(int i = 1; i <= N; i++) {
						System.out.print(temp[i] + " ");
					}
					System.out.println();
					
					solve(depth+1, cnt+1, temp);
					temp[nx] = false;
				} 
			}
		}

		solve(depth+1, cnt, v);
		
		System.out.println("------------end " + x);
	}

	private static boolean isIn(int x) {
		return x > 0 && x <= N;
	}
}