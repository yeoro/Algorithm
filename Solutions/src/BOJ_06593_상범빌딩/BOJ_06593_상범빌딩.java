package BOJ_06593_»ó¹üºôµù;

import java.io.*;
import java.util.*;

public class BOJ_06593_»ó¹üºôµù {
	
	static char[][][] building;
	static boolean[][][] v;
	static int[] dx = {-1, 1, 0, 0, 0, 0}, dy = {0, 0, -1, 1, 0, 0}, dz = {0, 0, 0, 0, 1, -1};
	static int L, R, C, min;
	static Queue<Path> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L == 0 && R == 0 && C == 0) {
				break;
			}
			
			building = new char[L][R][C];
			v = new boolean[L][R][C];
			q = new LinkedList<Path>();
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i < L; i++) {
				for(int j = 0; j < R; j++) {
					String temp = br.readLine();
					for(int k = 0; k < C; k++) {
						building[i][j][k] = temp.charAt(k);
						if(temp.charAt(k) == 'S') {
							q.add(new Path(i, j, k, 0));
						}
					}
				}
				br.readLine();
			}
			
			bfs();
			
			if(min == Integer.MAX_VALUE) {
				System.out.println("Trapped!");
			} else {
				System.out.println("Escaped in " + min + " minute(s).");
			}
		}
		
		br.close();
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			Path p = q.poll();
			
			for(int i = 0; i < 6; i++) {
				int nz = p.z + dz[i];
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(isIn(nz, nx, ny)) {
					if(!v[nz][nx][ny] && building[nz][nx][ny] == '.') {
						v[nz][nx][ny] = true;
						q.add(new Path(nz, nx, ny, p.dis+1));
					} else if(building[nz][nx][ny] == 'E') {
						min = Math.min(min, p.dis+1);
					}
				}
			}
		}
	}
	
	private static boolean isIn(int z, int x, int y) {
		return z >= 0 && z < L && x >= 0 && x < R && y >= 0 && y < C;
	}
}

class Path {
	int x, y, z, dis;

	public Path(int z, int x, int y, int dis) {
		this.z = z;
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
}

