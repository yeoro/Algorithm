package BOJ_02583_영역구하기;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
	}
	static int[][] paper;
	static boolean[][] v;
	static ArrayList<Integer> area = new ArrayList<Integer>();
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int M, N, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		paper = new int[M][N];
		v = new boolean[M][N];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			draw(st);
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(paper[i][j] == 0 && !v[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		
		Collections.sort(area);
		
		System.out.println(cnt);
		for(int i : area) {
			System.out.print(i + " ");
		}
		
		br.close();
	}
	
	private static void draw(StringTokenizer st) {
		int y1 = Integer.parseInt(st.nextToken());
		int x1 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken())-1;
		int x2 = Integer.parseInt(st.nextToken())-1;
		
		for(int i = x1; i <= x2; i++) {
			for(int j = y1; j <= y2; j++) {
				paper[i][j] = 1;
			}
		}
	}
	
	private static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Main.Node>();
		q.offer(new Node(x, y));
		v[x][y] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(isIn(nx, ny) && !v[nx][ny] && paper[nx][ny] == 0) {
					v[nx][ny] = true;
					q.offer(new Node(nx, ny));
					cnt++;
				}
			}
		}
		
		area.add(cnt);
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}
	
}

