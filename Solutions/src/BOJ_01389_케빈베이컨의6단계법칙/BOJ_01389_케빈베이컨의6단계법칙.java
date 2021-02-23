package BOJ_01389_케빈베이컨의6단계법칙;

import java.io.*;
import java.util.*;

public class BOJ_01389_케빈베이컨의6단계법칙 {
	
	static int[][] friends;
	static int result, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		friends = new int[N][N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int A = Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			
			friends[A][B] = 1;
			friends[B][A] = 1;
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(isAnotherNode(k, i, j) && isFriend(i, k) && isFriend(k, j)) {
						if(friends[i][j] == 0) {
							friends[i][j] = friends[i][k] + friends[k][j];
						} else {
							friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
						}
					}
				}
			}
		}
		
		
		for(int i = 0; i < N; i++) {
			int sum = 0;
			
			for(int j = 0; j < N; j++) {
				sum += friends[i][j];
			}

			if(min > sum) {
				min = sum;
				result = i+1;
			}
		}
		
		bw.write(result + "\n");
		
		br.close();
		bw.flush();
	}
	
	private static boolean isFriend(int x, int y) {
		return friends[x][y] > 0;
	}
	
	private static boolean isAnotherNode(int x, int y, int z) {
		return x != y && y != z && x != z;
	}
}

