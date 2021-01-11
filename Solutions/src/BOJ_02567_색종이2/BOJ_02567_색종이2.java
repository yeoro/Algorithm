package BOJ_02567_색종이2;

import java.util.Scanner;

public class BOJ_02567_색종이2 {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[101][101];
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			
			for(int j = R; j < R+10; j++) {
				for(int k = C; k < C+10; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] == 1) {
					for(int k = 0; k < 4; k++) {
						
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(map[nx][ny] == 0 && !isIn(nx, ny)) {
							result++;
						}
					}
				}
			}
		}
		
		System.out.println(result);
		sc.close();
	}
	
	static boolean isIn(int x, int y) {
		return x < 0 || x > 100 || y < 0 || y > 100;
	}
}

