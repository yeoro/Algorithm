package BOJ_02206_���μ����̵��ϱ�;

import java.io.*;
import java.util.*;

public class BOJ_02206_���μ����̵��ϱ� {
	
	static int[][] map, v;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N, M, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		v = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s.charAt(j) + "");
				v[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs(0, 0);
		
		if(min == Integer.MAX_VALUE) {
			bw.write(-1 + "\n");
		} else {
			bw.write(min + "\n");
		}
		
		br.close();
		bw.flush();
	}
	
	private static void bfs(int x, int y) {
		Queue<Path> q = new LinkedList<Path>();
		v[x][y] = 0;
		q.add(new Path(x, y, 1, 0));
		
		while(!q.isEmpty()) {
			Path p = q.poll();
			
			if(p.x == N-1 && p.y == M-1) {
				min = p.dis;
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				// �迭 ���� �� & ���� �湮���� ���� �� (�湮�迭�� �������� �ʱ�ȭ �߱� ������ �湮���� ���� ���� ���� p�� �湮�迭 ������ Ŀ����)
				if(isIn(nx, ny) && v[nx][ny] > p.status) {
					if(map[nx][ny] == 0) {
						v[nx][ny] = p.status;
						q.add(new Path(nx, ny, p.dis+1, p.status));
					} else if(map[nx][ny] == 1 && p.status == 0) {
						v[nx][ny] = p.status + 1;
						q.add(new Path(nx, ny, p.dis+1, p.status+1));
					}
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}

class Path {
	int x, y, dis, status;

	public Path(int x, int y, int dis, int status) {
		this.x = x;
		this.y = y;
		this.dis = dis;
		this.status = status;
	}
}