package BOJ_14503_�κ�û�ұ�;

import java.io.*;
import java.util.*;

public class BOJ_14503_�κ�û�ұ� {
	
	static boolean[][] v;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	static int N, M, r, c, d, res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		v = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		map[r][c] = 2;
		
		clean(r, c, d, 1);
		
		System.out.println(res);
		br.close();
	}
	
	private static void clean(int x, int y, int dir, int cnt) {
//		if(cnt == 30) {
//			return;
//		}
		
		// ���� ��ġ û��
		map[x][y] = 2;
		
		int curDir = dir;
		int curCnt = cnt;
		int nx = x;
		int ny = y;
		int check = 0;

//		System.out.println("���� ��ġ (" + nx + ", " + ny + ") " + cnt);
//		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		// ���鼭 û���� �� ã��
		while(true) {
			switch(curDir) {
			case 0: // ��
				curDir = 3;
				check++;
//				System.out.println("��: " + check);
				break;
			case 1: // ��
				curDir = 0;
				check++;
//				System.out.println("��: " + check);
				break;
			case 2: // ��
				curDir = 1;
				check++;
//				System.out.println("��: " + check);
				break;
			case 3: // ��
				curDir = 2;
				check++;
//				System.out.println("��: " + check);
				break;
			}

			nx = x + dx[curDir];
			ny = y + dy[curDir];

//			System.out.println("��ȯ (" + nx + ", " + ny + ") " + curDir);
			
			
			// û���� ������ ã���� ���� û�� ����
			if(isIn(nx, ny) && map[nx][ny] == 0) {
				clean(nx, ny, curDir, curCnt+1);
//				System.out.println("û�� (" + nx + ", " + ny + ")");
				return;
			} else { // ���� ���⿡ û���� ������ ���ٸ� ȸ�� �� �ٽ� Ž��
				if(check == 4) {
					// �� ���� ��� û�Ҹ� �߰ų� ���� ��� �� ĭ ����
					switch(curDir) {
					case 0: // ��
						nx = x+1;
						break;
					case 1: // ��
						ny = y-1;
						break;
					case 2: // ��
						nx = x-1;
						break;
					case 3: // ��
						ny = y+1;
						break;
					}
					
					if(isIn(nx, ny)) {
//						System.out.println("���� (" + nx + ", " + ny + ")");
						clean(nx, ny, curDir, curCnt);
						break;
					} else if(!isIn(nx, ny) && map[nx][ny] != 0){
						res = cnt;
						return;
					}
				}
			}
		}
	}
	
	
	private static boolean isIn(int x, int y) {
		return x > 0 && x < N-1 && y > 0 && y < M-1;
	}
}

