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
		
		clean(r, c, d);
		
		System.out.println(res+1);
		
		br.close();
	}
	
	private static void clean(int x, int y, int dir) {
		// ���� ��ġ û��
		map[x][y] = -1;
		
		int nDir = dir;
		
		// �� ������ Ž���ϸ� û���� �� ã��
		for(int i = 0; i < 4; i++) { 
			nDir = (nDir + 3) % 4;
			
			int nx = x + dx[nDir];
			int ny = y + dy[nDir];
			
			// û���� ���� ã�Ҵٸ� ���ȣ�� �� ���� �Լ� ����
			if(map[nx][ny] == 0) {
				res++;
				clean(nx, ny, nDir);
				return;
			}
		}
		
		// �� ������ Ž���ϰ� û���� ���� ã�� ���ߴٸ� ���� �� �ٽ� Ž��
		int bx = x - dx[dir];
		int by = y - dy[dir];
		
		// ���̶� ������ ���ϴ� ��� ����
		if(map[bx][by] == 1) {
			return;
		} else {
			clean(x-dx[dir], y-dy[dir], dir);
		}
	}
}

