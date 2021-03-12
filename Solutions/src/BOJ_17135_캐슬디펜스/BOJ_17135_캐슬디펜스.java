package BOJ_17135_캐슬디펜스;

import java.io.*;
import java.util.*;

public class BOJ_17135_캐슬디펜스 {
	
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int[][] map, copy;
	static int N, M, D, kill, max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M];
		copy = new int[N+1][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeArcher(0, 0);
		
		System.out.println(max);
		
		br.close();
	}
	
	private static void makeArcher(int cur, int cnt) {
		if(cnt == 3) {
			copy();
			
			kill = 0;
			while(attack()) {
				move();
			}
			
			max = Math.max(kill, max);
			
			return;
		}
		
		for(int i = cur; i < M; i++) {
			if(map[N][i] == 0) {
				map[N][i] = 2;
				makeArcher(i, cnt+1);
				map[N][i] = 0;
			}
		}
	}
	
	private static void copy() {
		for(int i = 0; i < N+1; i++) {
			for(int j = 0; j < M; j++) {
				System.arraycopy(map[i], 0, copy[i], 0, map[i].length);
			}
		}
	}
	
	private static boolean attack() {
		boolean left = false;
		ArrayList<Enemy> e = new ArrayList<Enemy>();
		
		for(int i = 0; i < M; i++) {
			if(copy[N][i] == 2) {
				ArrayList<Enemy> temp = new ArrayList<Enemy>(); 
				
				// 적을 발견하면 공격
				for(int j = N-1; j >= 0; j--) {
					for(int k = 0; k < M; k++) {
						if(copy[j][k] == 1 && canAttack(N, i, j, k)) {
							int dis = Math.abs(N - j) + Math.abs(i - k);
							temp.add(new Enemy(j, k, dis));
						}
					}
				}
				
				Collections.sort(temp);
				
				if(temp.size() != 0) {
					e.add(temp.get(0));
				}
			}
		}
		
		for(Enemy temp : e) {
			if(copy[temp.x][temp.y] != 0) {
				copy[temp.x][temp.y] = 0;
				kill++;
			}
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copy[i][j] == 1) {
					left = true;
				}
			}
		}
		
		return left;
	}
	
	private static boolean canAttack(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2) <= D;
	}
	
	private static void move() {
		for(int i = N-1; i >= 0; i--) {
			for(int j = 0; j < M; j++) {
				if(copy[i][j] == 1) {
					if(i+1 == N) {
						copy[i][j] = 0;
						continue;
					} 
					
					int temp = copy[i+1][j];
					copy[i+1][j] = copy[i][j];
					copy[i][j] = temp;
				}
			}
		}
	}
}

class Enemy implements Comparable<Enemy>{
	int x, y, dis;

	public Enemy(int x, int y, int dis) {
		this.x = x;
		this.y = y;
		this.dis = dis;
	}

	@Override
	public int compareTo(Enemy o) {
		if(this.dis - o.dis == 0) {
			return this.y - o.y;
		}
		return this.dis - o.dis;
	}
}

