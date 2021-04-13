package BOJ_06987_¿ùµåÄÅ;

import java.io.*;
import java.util.*;

public class BOJ_06987_¿ùµåÄÅ {
	
	static int[][] result = new int[6][3];
	static int[][] temp = new int[6][3];
	static int[] team1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
	static int[] team2 = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
	static int[] res = new int[4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		loop: for(int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int gameCnt = 0;
			
			for(int j = 0; j < 6; j++) {
				for(int k = 0; k < 3; k++) {
					result[j][k] = Integer.parseInt(st.nextToken());
					
					gameCnt += result[j][k];
				}
			}
			
			if(gameCnt != 30) {
				continue loop;
			}
			
			play(i, 0);
			
		}

		for(int j : res) {
			System.out.print(j + " ");
		}
		
		br.close();
	}
	
	private static void play(int tc, int depth) {
		if(depth == 15) {
			if(res[tc] == 0) {
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < 3; j++) {
						if(result[i][j] != temp[i][j]) {
							return;
						}
					}
				}
				
				res[tc] = 1;
			}
			
			return;
		}
		
		int t1 = team1[depth];
		int t2 = team2[depth];
		
		// t1 ½Â¸®, t2 ÆĞ¹è
		temp[t1][0]++;
		temp[t2][2]++;
		play(tc, depth+1);
		temp[t1][0]--;
		temp[t2][2]--;
		
		// t1, t2 ¹«½ÂºÎ
		temp[t1][1]++;
		temp[t2][1]++;
		play(tc, depth+1);
		temp[t1][1]--;
		temp[t2][1]--;
		
		// t1 ÆĞ¹è, t2 ½Â¸®
		temp[t1][2]++;
		temp[t2][0]++;
		play(tc, depth+1);
		temp[t1][2]--;
		temp[t2][0]--;
	}
}

