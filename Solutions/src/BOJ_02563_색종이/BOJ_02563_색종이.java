package BOJ_02563_색종이;

import java.util.Scanner;

public class BOJ_02563_색종이 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		boolean[][] map = new boolean[100][100];
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			
			for(int j = R; j < R+10; j++) {
				for(int k = C; k < C+10; k++) {
					map[99-k][j] = true;
				}
			}
		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] == true) {
					result++;
				}
			}
		}
		
		System.out.println(result);
		sc.close();
	}
}
