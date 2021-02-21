package BOJ_01012_¿Ø±‚≥ÛπË√ﬂ;

import java.io.*;
import java.util.*;

public class BOJ_01012_¿Ø±‚≥ÛπË√ﬂ {
	
	static int[][] farm;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int M, N, K, worm;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			farm = new int[N][M];
			v = new boolean[N][M];
			worm = 0;
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				farm[y][x] = 1;
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(farm[i][j] == 1 && !v[i][j]) {
						v[i][j] = true;
						bfs(i, j);
						worm++;
					}
				}
			}
			
			bw.write(worm + "\n");
		}
		
		br.close();
		bw.flush();
	}
	
	private static void bfs(int x, int y) {
		Queue<Cabbage> q = new LinkedList<Cabbage>();
		q.add(new Cabbage(x, y));
		
		while(!q.isEmpty()) {
			Cabbage c = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];
				
				if(isIn(nx, ny) && !v[nx][ny] && farm[nx][ny] == 1) {
					v[nx][ny] = true;
					q.add(new Cabbage(nx, ny));
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}

class Cabbage {
	int x, y;

	public Cabbage(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

