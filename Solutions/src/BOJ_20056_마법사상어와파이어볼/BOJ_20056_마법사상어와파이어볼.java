package BOJ_20056_������������̾;

import java.io.*;
import java.util.*;

public class BOJ_20056_������������̾ {
	
	static int[][] map;
	static boolean[][] v;
	static ArrayList<Fireball>[][] fbList;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int N, M, K, res;
	static Queue<Fireball> q = new LinkedList<Fireball>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		fbList = new ArrayList[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				fbList[i][j] = new ArrayList<Fireball>();
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			Fireball input = new Fireball(x, y, m, s, d);
			
			fbList[x][y].add(input);
//			map[x][y]++;
			q.add(input);
		}
		
		bfs();
		
		System.out.println(res);
		
		br.close();
	}
	
	private static void bfs() {
		for(int k = 0; k < K; k++) {
			v = new boolean[N][N];
			ArrayList<Node> temp = new ArrayList<Node>();
			
			// ���̾ �̵�
			for(int i = 0, size = q.size(); i < size; i++) {
				Fireball fb = q.poll();
				
				int x = fb.x;
				int y = fb.y;
				int m = fb.m;
				int s = fb.s;
				int d = fb.d;
				
				if(m == 0) {
					continue;
				}
				
				System.out.println("����: " + fb.toString() + " " + k);
				
				int nx = 0;
				int ny = 0;
				int px = x;
				int py = y;
				
				for (int a = 0; a < s; a++) {
			         nx = px + dx[d];
			         ny = py + dy[d];
			         if (nx == -1) nx = N-1;
			         if (ny == -1) ny = N-1;
			         if (nx >= N) nx = 0;
			         if (ny >= N) ny = 0;
			         px = nx;
			         py = ny;
			      }
				
//				int nx = modifyIdx(x + dx[d]*(s % N));
//				int ny = modifyIdx(y + dy[d]*(s % N));
				
//				  int nr = f.r + rArr[f.d] * (f.s % n);
//                int nc = f.c + cArr[f.d] * (f.s % n);
//                if(nr > 0) nr %= n;
//                if(nc > 0) nc %= n;
//                if(nr < 0) nr = n - Math.abs(nr);
//                if(nc < 0) nc = n - Math.abs(nc);

				Fireball move = new Fireball(nx, ny, m, s, d);

				// ���� ĭ���� ���� ĭ���� ���̾ �̵�
//				map[x][y]--;
				fbList[x][y].remove(fb);
				
				// ���� ĭ�� �����ϴ� ���̾ ���� ����
//				map[nx][ny]++;
				fbList[nx][ny].add(move);
				
				System.out.println("���� ĭ ����: " + fbList[x][y].size());
				System.out.println("�̵�: " + move.toString());
				System.out.println("���� ĭ ����: " + fbList[nx][ny].size());
//				System.out.println(map[nx][ny] + " " + nx + " " + ny);

				// ���� ĭ�� �����ϴ� ���̾�� ������ �۾��� �ϰų� �۾� ���� ť�� ����ֱ� ���� ��ġ ����
				if(!v[nx][ny]) {
					temp.add(new Node(nx, ny));
					v[nx][ny] = true;
				}
			}
			
			// ���̾ ť�� �ֱ�
			if(temp.size() > 0) {
				for(Node n : temp) {
					int x = n.x;
					int y = n.y;
					int cnt = fbList[x][y].size();
					
					if(cnt >= 2) { // ���� ĭ�� ���̾�� 2�� �̻� �����Ѵٸ� ������ ť�� ����
						
						// ���� ĭ�� �ִ� ���̾ ���� �� ��
						int m = 0;
						
						// ���� ĭ�� �ִ� ���̾ �ӵ� �� ��
						int s = 0;
						
						boolean even = false;
						boolean odd = false;
						
						for(Fireball fb : fbList[x][y]) {
							System.out.println("������: " + fb.toString());
							m += fb.m;
							s += fb.s;
							
							if(fb.d % 2 == 0) {
								even = true;
							} else {
								odd = true;
							}
						}
						
						// ������ ���̾ ������ �� / 5
						m /= 5;
						
						// ������ ���̾ �ӷ��� �� / ������ ���̾ ����
						s /= cnt;
						
						if(even != odd) { // ������ ��� ¦���ų� Ȧ���� ���
							for(int i = 0; i <= 6; i+=2) {
								System.out.println("����1");
								fbList[x][y].add(new Fireball(x, y, m, s, i));
								q.offer(new Fireball(x, y, m, s, i));
							}
						} else {
							for(int i = 1; i <= 7; i+=2) {
								System.out.println("����2");
								fbList[x][y].add(new Fireball(x, y, m, s, i));
								q.offer(new Fireball(x, y, m, s, i));
							}
						}
						
					} else if(fbList[x][y].size() > 0) { // ���� ĭ�� ���̾�� 1�� �����ϸ� ������ �۾� ���� ť�� ����
						q.offer(fbList[x][y].get(0));
					}
				}
			}
		}
		
		for(int i = 0, size = q.size(); i < size; i++) {
			Fireball fb = q.poll();

			System.out.println("��������: " + fb.toString());
			res += fb.m;
		}

		return;
		
	}
	
	private static int modifyIdx(int n) {
		int m = 0;
		
		if(m > 0) {
			m = n % N;
		} else if (m < 0) {
			m = N - Math.abs(n);
		}
		
		return m;
	}
}

class Node {
	int x, y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Fireball {
	int x, y, m, s, d;

	public Fireball(int x, int y, int m, int s, int d) {
		this.x = x;
		this.y = y;
		this.m = m;
		this.s = s;
		this.d = d;
	}

	@Override
	public String toString() {
		return "Fireball [x=" + x + ", y=" + y + ", m=" + m + ", s=" + s + ", d=" + d + "]";
	}
}

