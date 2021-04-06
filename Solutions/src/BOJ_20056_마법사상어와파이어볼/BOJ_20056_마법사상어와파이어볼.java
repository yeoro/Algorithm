package BOJ_20056_������������̾;

import java.io.*;
import java.util.*;

public class BOJ_20056_������������̾ {
	
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
		}
		
		solve();
		
		System.out.println(res);
		
		br.close();
	}
	
	private static void solve() {
		while(K-- > 0) {
			// ���̾ �̵�
			moveFireball();
			
			// ���̾�� 2�� �̻� �����ϴ� ĭ ������ �۾�
			divFireball();
		}
		
		// �����ִ� ���̾ ���� ���
		calM();
	}
	
	private static void moveFireball() {
		ArrayList<Fireball> temp = new ArrayList<Fireball>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(fbList[i][j].size() > 0) {
					for(int k = 0; k < fbList[i][j].size(); k++) {
						Fireball fb = fbList[i][j].get(k);
						
						int x = fb.x;
						int y = fb.y;
						int m = fb.m;
						int s = fb.s;
						int d = fb.d;
						
						
						System.out.println(nx + " " + ny);
						Fireball mv = new Fireball(nx, ny, m, s, d);
						
						fbList[i][j].remove(k--);
						temp.add(mv);
					}
				}
			}
		}
		
		// ���̾ �̵�
		for(Fireball fb : temp) {
			fbList[fb.x][fb.y].add(fb);
		}
	}
	
	private static void divFireball() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int size = fbList[i][j].size();
				
				if(size >= 2) {
					// ����, �ӵ��� ������ ���� ����
					int mTotal = 0;
					int sTotal = 0;
					
					// ������ ���ϱ� ���� ����
					boolean odd = false;
					boolean even = false;
					
					for(Fireball fb : fbList[i][j]) {
						mTotal += fb.m;
						sTotal += fb.s;
						
						if(fb.d % 2 == 0) {
							even = true;
						} else {
							odd = true;
						}
						
//						System.out.println("������: " + fb.toString());
					}
					
					mTotal /= 5;
					sTotal /= size;
					
					fbList[i][j].clear();

					// ������ ��� ¦��, Ȧ���̸� (0, 2, 4, 6), �ƴϸ� (1, 3, 5, 7)
					int d;
					if(even != odd) {
						d = 0;
					} else {
						d = 1;
					}
						
					for(int k = 0; k < 4; k++) {
						Fireball fb = new Fireball(i, j, mTotal, sTotal, d+=2*k);
						
						fbList[i][j].add(fb);
						
//						System.out.println("����: " + fb.toString());
					}
				}
			}
		}
	}
	
	private static void calM() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(fbList[i][j].size() > 0) {
					for(Fireball fb : fbList[i][j]) {
						res += fb.m;
					}
				}
			}
		}
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

