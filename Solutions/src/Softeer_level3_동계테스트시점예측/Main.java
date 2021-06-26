package Softeer_level3_동계테스트시점예측;

import java.util.*;
import java.io.*;


public class Main
{
	static class Node {
		int x, y;

		public Node(int x, int y) { 
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
	static ArrayList<Node> list = new ArrayList<Node>();
	static Queue<Node> temp = new LinkedList<Node>();
	static int[][] map, cnt;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N, M, time;

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];


		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve();


		br.close();
	}

	private static void solve() {
		while(true) {
			cnt = new int[N][M];
			v = new boolean[N][M];

			// 외부 공기 판단
			loop: for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 0 && !v[i][j]) {
						air(i, j);
						break loop;
					}
				}
			}

			// 얼음 녹이기
			if(pickIce()) {
				System.out.println("-------------- pick");
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						System.out.print(cnt[i][j] + " ");
					}
					System.out.println();
				}
				melt();
				System.out.println("-------------- melt");
				print();
				time++;
			} else {
				System.out.println("time: " + time);
				break;
			}
		}
	}

	private static void air(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(x, y));
		v[x][y] = true;

		while(!q.isEmpty()) {
			Node cur = q.poll();
			x = cur.x;
			y = cur.y;
			boolean chk = false;

//			 System.out.println(cur.toString());

			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(isIn(nx, ny)) {
					if(!v[nx][ny] && map[nx][ny] == 0) {
						v[nx][ny] = true;
						q.offer(new Node(nx, ny));
					}  else if(map[nx][ny] == 1) {
						chk = true;
					}
				}
			}

			if(chk) {
				temp.offer(cur);
			}
		}
	}

	private static boolean pickIce() {
		while(!temp.isEmpty()) {
			Node cur = temp.poll();
			int x = cur.x;
			int y = cur.y;

			 System.out.println("--------------- " + cur.toString());

			// 공기 주변에 얼음이 있으면 해당 얼음 자리에 카운트 증가
			for(int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if(isIn(nx, ny) && map[nx][ny] == 1) {
					 System.out.println(nx + " " + ny);
					cnt[nx][ny]++;
				}
			}
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(cnt[i][j] >= 2) {
					list.add(new Node(i, j));
				}
			}
		}

		if(list.size() > 0) {
			return true;
		}

		return false;
	}

	private static void melt() {
		for(Node i : list) {
			map[i.x][i.y] = 0;
		}

		list.clear();
	}

	private static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}