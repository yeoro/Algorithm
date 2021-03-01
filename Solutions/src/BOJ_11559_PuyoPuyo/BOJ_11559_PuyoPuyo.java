package BOJ_11559_PuyoPuyo;

import java.io.*;
import java.util.*;

public class BOJ_11559_PuyoPuyo {
	
	static char[][] field = new char[12][6];
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int bomb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < 12; i++) {
			String s = br.readLine();
			for(int j = 0; j < 6; j++) {
				field[i][j] = s.charAt(j);
			}
		}
		
		while(crash()) {
			fall();
			bomb++;
		}
		
		bw.write(bomb + "\n");
		
		br.close();
		bw.flush();
	}
	
	private static boolean crash() {
		boolean crashed = false;
		v = new boolean[12][6];
		
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 6; j++) {
				if(!v[i][j] && isPuyo(field[i][j])) {
					v[i][j] = true;

					if(bfs(i, j)) {
						crashed = true;
					}
				}
			}
		}
		return crashed;
	}
	
	private static boolean bfs(int x, int y) {
		Queue<Puyo> q = new LinkedList<Puyo>();
		LinkedList<Puyo> list = new LinkedList<Puyo>();
		q.add(new Puyo(x, y));
		list.add(new Puyo(x, y));
		
		while(!q.isEmpty()) {
			Puyo p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(isIn(nx, ny) && !v[nx][ny] && field[nx][ny] == field[x][y]) {
					v[nx][ny] = true;
					q.add(new Puyo(nx, ny));
					list.add(new Puyo(nx, ny));
				}
			}
		}

		if(list.size() >= 4) {
			for(Puyo temp : list) {
				field[temp.x][temp.y] = '.';
			}
			return true;
		} else {
			return false;
		}
	}
	
	private static void fall() {
		for(int j = 0; j < 6; j++) {
			for(int i = 11; i >= 0; i--) {
				if(field[i][j] == '.') {
					continue;
				}
				
				for(int k = 11; k >= i; k--) {
					if(field[k][j] == '.') {
						field[k][j] = field[i][j];
						field[i][j] = '.';
					}
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < 12 && y >= 0 && y < 6;
	}
	
	private static boolean isPuyo(char c) {
		return c == 'R' || c == 'G' || c == 'B' || c == 'P' || c == 'Y'; 
	}
}

class Puyo {
	int x, y;

	public Puyo(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

