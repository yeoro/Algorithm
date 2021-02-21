package BOJ_02468_안전영역;

import java.io.*;
import java.util.*;

public class BOJ_02468_안전영역 {
	
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, max, cnt, result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				int height = Integer.parseInt(st.nextToken());
				map[i][j] = height;
				max = Math.max(height, max);
			}
		}
		
		for(int i = 0; i <= max; i++) {
			v = new boolean[N][N];
			cnt = 0;
			
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					if(map[j][k] > i && !v[j][k]) {
						v[j][k] = true;
						bfs(j, k, i);
						cnt++;
					}
				}
			}
			
			result = Math.max(cnt, result);
		}
		
		bw.write(result + "\n");
		
		br.close();
		bw.flush();
	}
	
	private static void bfs(int x, int y, int rain) {
		Queue<Region> q = new LinkedList<Region>();
		q.add(new Region(x, y));
		
		while(!q.isEmpty()) {
			Region r = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = r.x + dx[i];
				int ny = r.y + dy[i];
				
				if(isIn(nx, ny) && !v[nx][ny] && map[nx][ny] > rain) {
					v[nx][ny] = true;
					q.add(new Region(nx, ny));
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

class Region {
	int x, y;

	public Region(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

