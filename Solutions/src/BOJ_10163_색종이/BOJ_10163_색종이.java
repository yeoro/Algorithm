package BOJ_10163_색종이;

import java.util.Scanner;

public class BOJ_10163_색종이 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[101][101];
		
		for(int i = 1; i <= N; i++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			int W = sc.nextInt();
			int H = sc.nextInt();
			
			for(int j = R; j < R+W; j++) {
				for(int k = C; k < C+H; k++) {
					map[100-k][j] = i;
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			int result = 0;
			
			for(int j = 0; j < 101; j++) {
				for(int k = 0; k < 101; k++) {
					if(map[j][k] == i) {
						result++;
					}
				}
			}
			System.out.println(result);
		}
		
		sc.close();
	}
}
