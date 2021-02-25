package BOJ_02146_다리만들기;

import java.io.*;
import java.util.*;

public class BOJ_02146_다리만들기 {
	
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, island, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 구분짓기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!v[i][j] && map[i][j] == 1) {
					v[i][j] = true;
					map[i][j] = island+1;
					divide(i, j);
					island++;
				}
			}
		}
		
		// 다리 놓기
		v = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!v[i][j] && map[i][j] != 0) { // 아직 다리를 놓지 않은 육지인 경우 탐색
					v[i][j] = true;
					bfs(i, j);
					v = new boolean[N][N]; // 다음 육지에서의 탐색을 위해 방문 배열 초기화
				}
			}
		}
		
		bw.write(min + "\n");
		
		br.close();
		bw.flush();
	}
	
	private static void divide(int x, int y) {
		Queue<Island> q = new LinkedList<Island>();
		q.add(new Island(x, y));
		
		while(!q.isEmpty()) {
			Island is = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = is.x + dx[i];
				int ny = is.y + dy[i];
				
				if(isIn(nx, ny) && !v[nx][ny] && map[nx][ny] == 1) {
					v[nx][ny] = true;
					map[nx][ny] = island+1;
					q.add(new Island(nx, ny));
				}
			}
		}
	}
	
	private static void bfs(int x, int y) {
		Queue<Bridge> q = new LinkedList<Bridge>();
		q.add(new Bridge(x, y, 0));
		
		while(!q.isEmpty()) {
			Bridge b = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = b.x + dx[i];
				int ny = b.y + dy[i];
				
				if(isIn(nx, ny)) {
					if(map[nx][ny] == 0 && !v[nx][ny]) { // 인접한 곳이 바다이면 큐에 삽입
						v[nx][ny] = true;
						q.add(new Bridge(nx, ny, b.length+1));
					} else if(map[nx][ny] != 0 && map[nx][ny] != map[x][y]) { // 다른 섬에 도착했을 경우 다리의 최솟값 갱신
						min = Math.min(min, b.length);
					}
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

class Island {
	int x, y;

	public Island(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Bridge {
	int x, y, length;

	public Bridge(int x, int y, int length) {
		this.x = x;
		this.y = y;
		this.length = length;
	}
}
