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
	}
	static ArrayList<Node> iceList = new ArrayList<Node>(); // 녹일 얼음
	static Queue<Node> airList = new LinkedList<Node>(); // 얼음을 녹일 공기
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
			cnt = new int[N][M]; // 인접한 공기의 수를 저장할 배열
			v = new boolean[N][M];

			// 얼음이 인접한 외부 공기만 골라내는 작업
			loop: for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 0 && !v[i][j]) {
						air(i, j);
						break loop;
					}
				}
			}

			if(pickIce()) { // 2개 이상의 공기와 인접한 얼음을 골라내는 작업
				melt(); // 얼음 녹이기
				time++; // 시간 증가
			} else {
				// 녹일 얼음이 없다면 시간을 출력하고 종료
				System.out.println(time);
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

			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(isIn(nx, ny)) {
					if(!v[nx][ny] && map[nx][ny] == 0) { // 공기일 경우 큐에 넣음
						v[nx][ny] = true;
						q.offer(new Node(nx, ny));
					} else if(map[nx][ny] == 1) { // 얼음일 경우
						chk = true;
					}
				}
			}

			// 주변에 얼음이 있는 공기인 경우는 얼음을 녹이기 위해 리스트에 저장
			if(chk) {
				airList.offer(cur);
			}
		}
	}

	private static boolean pickIce() {
		while(!airList.isEmpty()) {
			Node cur = airList.poll();
			int x = cur.x;
			int y = cur.y;

			// 공기 주변에 얼음이 있으면 해당 얼음 자리에 카운트 증가
			for(int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if(isIn(nx, ny) && map[nx][ny] == 1) {
					cnt[nx][ny]++;
				}
			}
		}
		
		// 2개 이상의 공기와 인접한 얼음을 녹이기 위해 리스트에 저장
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(cnt[i][j] >= 2) {
					iceList.add(new Node(i, j));
				}
			}
		}
		
		// 녹일 얼음이 존재하는 경우에만 작업 진행
		if(iceList.size() > 0) {
			return true;
		}

		return false;
	}

	private static void melt() {
		for(Node i : iceList) {
			map[i.x][i.y] = 0;
		}

		iceList.clear();
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}