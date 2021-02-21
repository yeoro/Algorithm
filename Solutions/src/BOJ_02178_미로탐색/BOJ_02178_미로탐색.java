package BOJ_02178_¹Ì·ÎÅ½»ö;

import java.io.*;
import java.util.*;

public class BOJ_02178_¹Ì·ÎÅ½»ö {
	
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, M;
	static int cnt = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		v = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s.charAt(j)+"");
			}
		}
		
		v[0][0] = true;
		bfs(0, 0);
		
		bw.write(cnt + "\n");
		
		br.close();
		bw.flush();
	}
	
	private static void bfs(int x, int y) {
		Queue<Maze> q = new LinkedList<Maze>();
		q.add(new Maze(x, y));
		
		while(!q.isEmpty()) {
			Maze m = q.poll();
			
			if(m.x == N-1 && m.y == M-1) {
				cnt = Math.min(cnt, map[m.x][m.y]);
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = m.x + dx[i];
				int ny = m.y + dy[i];
				
				if(isIn(nx, ny) && !v[nx][ny] && map[nx][ny] == 1) {
					v[nx][ny] = true;
					map[nx][ny] = map[m.x][m.y] + 1;
					
					q.add(new Maze(nx, ny));
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}

class Maze {
	int x, y;

	public Maze(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

