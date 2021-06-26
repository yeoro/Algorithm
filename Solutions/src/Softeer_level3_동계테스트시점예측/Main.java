package Softeer_level3_�����׽�Ʈ��������;

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
	static ArrayList<Node> iceList = new ArrayList<Node>(); // ���� ����
	static Queue<Node> airList = new LinkedList<Node>(); // ������ ���� ����
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
			cnt = new int[N][M]; // ������ ������ ���� ������ �迭
			v = new boolean[N][M];

			// ������ ������ �ܺ� ���⸸ ��󳻴� �۾�
			loop: for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 0 && !v[i][j]) {
						air(i, j);
						break loop;
					}
				}
			}

			if(pickIce()) { // 2�� �̻��� ����� ������ ������ ��󳻴� �۾�
				melt(); // ���� ���̱�
				time++; // �ð� ����
			} else {
				// ���� ������ ���ٸ� �ð��� ����ϰ� ����
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
					if(!v[nx][ny] && map[nx][ny] == 0) { // ������ ��� ť�� ����
						v[nx][ny] = true;
						q.offer(new Node(nx, ny));
					} else if(map[nx][ny] == 1) { // ������ ���
						chk = true;
					}
				}
			}

			// �ֺ��� ������ �ִ� ������ ���� ������ ���̱� ���� ����Ʈ�� ����
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

			// ���� �ֺ��� ������ ������ �ش� ���� �ڸ��� ī��Ʈ ����
			for(int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if(isIn(nx, ny) && map[nx][ny] == 1) {
					cnt[nx][ny]++;
				}
			}
		}
		
		// 2�� �̻��� ����� ������ ������ ���̱� ���� ����Ʈ�� ����
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(cnt[i][j] >= 2) {
					iceList.add(new Node(i, j));
				}
			}
		}
		
		// ���� ������ �����ϴ� ��쿡�� �۾� ����
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