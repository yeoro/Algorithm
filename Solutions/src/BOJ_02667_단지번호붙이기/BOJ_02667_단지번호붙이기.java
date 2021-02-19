package BOJ_02667_단지번호붙이기;

import java.io.*;
import java.util.*;

public class BOJ_02667_단지번호붙이기 {
	
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, block, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		v = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s.charAt(j) + "");
			}
		}
		
		block = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !v[i][j]) {
					cnt = 1;
					map[i][j] = block;
					v[i][j] = true;
					
					dfs(i, j, block);
					
					block++;
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		
		bw.write((block-1) + "\n");
		for(int i : list) {
			bw.write(i + "\n");
		}
		
		br.close();
		bw.flush();
	}
	
	private static void dfs(int x, int y, int b) {
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isIn(nx, ny) && map[nx][ny] == 1 && !v[nx][ny]) {
				map[nx][ny] = b;
				v[nx][ny] = true;
				cnt++;
				dfs(nx, ny, b);
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

