package BOJ_10157_�ڸ�����;

import java.io.*;
import java.util.*;

class Main {
	
	static int[][] seat;
	static int C, R, K, size, no=1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		seat = new int[R+1][C+1];
		
		K = Integer.parseInt(br.readLine());
		
		if(R % 2 == 0) {
			size = R/2;
		} else {
			size = R/2 + 1;
		}
		
		if(R*C < K) {
			System.out.println(0);
		} else if(K == 1) {
			System.out.println(1 + " " + 1);
		} else {
			int x = 0; int y = 0;
			
			loop: for(int i = 0; i < size; i++) {
				// ������ �ʱ�ȭ
				x = R-i; y = 1+i;
				
				if(check(no)) {
					break loop;
				}
				
				seat[x][y] = no++;
				
				// ��
				while(isIn(x-1, y) && seat[x-1][y] == 0) {
					if(check(no)) {
						x--;
						break loop;
					}
					
					seat[--x][y] = no++;
				}
				
				// ��
				while(isIn(x, y+1) && seat[x][y+1] == 0) {
					if(check(no)) {
						y++;
						break loop;
					}
					
					seat[x][++y] = no++;
				}
				
				// ��
				while(isIn(x+1, y) && seat[x+1][y] == 0) {
					if(check(no)) {
						x++;
						break loop;
					}
					
					seat[++x][y] = no++;
				}
				
				// ��
				while(isIn(x, y-1) && seat[x][y-1] == 0) {
					if(check(no)) {
						y--;
						break loop;
					}
					
					seat[x][--y] = no++;
				}
			}
			
			System.out.println(y + " " + (R-x+1));
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x > 0 && x <= R && y > 0 && y <= C;
	}
	
	private static boolean check(int cur) {
		return cur == K;
	}
}