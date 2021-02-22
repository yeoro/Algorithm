package BOJ_01743_음식물피하기;

import java.io.*;
import java.util.*;

public class BOJ_01743_음식물피하기 {
	
	static int[][] floor;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, M, max, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		floor = new int[N][M];
		v = new boolean[N][M];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			floor[x-1][y-1] = 1;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(floor[i][j] == 1 && !v[i][j]) {
					cnt = 1;
					v[i][j] = true;
					bfs(i, j);
				}
			}
		}
		
		bw.write(max + "\n");
		
		br.close();
		bw.flush();
	}
	
	private static void bfs(int x, int y) {
		Queue<Waste> q = new LinkedList<Waste>();
		q.add(new Waste(x, y));
		
		while(!q.isEmpty()) {
			Waste w = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = w.x + dx[i];
				int ny = w.y + dy[i];
				
				if(isIn(nx, ny) && !v[nx][ny] && floor[nx][ny] == 1) {
					v[nx][ny] = true;
					q.add(new Waste(nx, ny));
					cnt++;
				}
			}
			
			max = Math.max(cnt, max);
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}

class Waste {
	int x, y;

	public Waste(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

