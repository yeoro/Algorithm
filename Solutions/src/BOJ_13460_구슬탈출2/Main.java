package BOJ_13460_±∏ΩΩ≈ª√‚2;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node {
		int x, y, cnt;

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}
		
		
	}
	static char[][] toy, copy;
	static boolean[][][] v;
	static Node[] bead;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N, M, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		toy = new char[N][M];
		copy = new char[N][M];
		v = new boolean[N][M][2];
		bead = new Node[2];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			
			for(int j = 0; j < M; j++) {
				toy[i][j] = input.charAt(j);
				
				if(toy[i][j] == 'R') {
					bead[0] = new Node(i, j, 0);
				} 
				
				if(toy[i][j] == 'B') {
					bead[1] = new Node(i, j, 0);
				}
			}
		}
		
		copyArr();
		
		solve();
		
		System.out.println(min);
		
		br.close();
		
	}
	
	private static void solve() {
		Queue<Node[]> q = new LinkedList<Main.Node[]>();
		q.offer(bead);
		
		while(!q.isEmpty()) {
			Node[] cur = q.poll();
			Node r = cur[0];
			Node b = cur[1];
			
			if(r.cnt > 10) {
				continue;
			}
			
			if(toy[r.x][r.y] == 'O') {
				min = Math.min(min, r.cnt);
			}
			
			for(int i = 0; i < 4; i++) {
				
				int rx = r.x + dx[i]; int ry = r.y + dy[i];
				if(isIn(rx, ry) && !v[rx][ry][0] && toy[rx][ry] != '#') {
					v[rx][ry][0] = true;
					toy[r.x][r.y] = '.';
					toy[rx][ry] = 'R';
					
					cur[0] = new Node(rx, ry, r.cnt+1);
				}
				
				
				int bx = b.x + dx[i]; int by = b.y + dy[i];
				if(isIn(bx, by) && !v[bx][by][1] && toy[bx][by] != '#') {
					v[bx][by][1] = true;
					toy[b.x][r.y] = '.';
					toy[bx][by] = 'B';
					
					cur[1] = new Node(rx, ry, r.cnt+1);
				}
				
				
			}
			
		}
	}
	
	private static void copyArr() {
		for(int i = 0; i < N; i++) {
			System.arraycopy(toy[i], 0, copy[i], 0, toy[i].length);
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}

