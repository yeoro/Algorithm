package BOJ_20056_마법사상어와파이어볼;

import java.io.*;
import java.util.*;

public class BOJ_20056_마법사상어와파이어볼 {
	
	static boolean[][] v;
	static ArrayList<Fireball>[][] fbList;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static boolean curMove;
	static int N, M, K, res;
	
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
			
			Fireball input = new Fireball(x, y, m, s, d, !curMove);
			
			fbList[x][y].add(input);
		}
		
		solve();
		
		System.out.println(res);
		
		br.close();
	}
	
	private static void solve() {
		while(K-- > 0) {
			// 파이어볼 이동
			moveFireball();
			
			// 파이어볼이 2개 이상 존재하는 칸 나누기 작업
			divFireball();
			
			// 플래그 변수를 바꿔 새로운 이동이 시작됨을 나타냄
			curMove = !curMove;
		}
		
		// 남아있는 파이어볼 질량 계산
		calM();
	}
	
	private static void moveFireball() {
		v = new boolean[N][N];
		
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
						boolean isMoved = fb.isMoved;
						
						// 이번 이동에서 움직였으면 건너뜀
						if(isMoved == curMove) {
							continue;
						}
						
//						System.out.println("현재: " + fb.toString() + " " + k);
						
						int nx = (x + dx[d] * s) % N;
						int ny = (y + dy[d] * s) % N;
						
						if(nx < 0) nx += N;
						if(ny < 0) ny += N;
						
						Fireball mv = new Fireball(nx, ny, m, s, d, curMove);
						
						// 움직일 위치로 이동
						fbList[i][j].remove(k--);
						fbList[nx][ny].add(mv);
						
//						System.out.println("이동: " + mv.toString() + " " + k);
					}
				}
			}
		}
	}
	
	private static void divFireball() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int size = fbList[i][j].size();
				
				if(size >= 2) {
					// 질량, 속도를 나누기 위한 변수
					int mTotal = 0;
					int sTotal = 0;
					
					// 방향을 정하기 위한 변수
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
						
//						System.out.println("합쳐짐: " + fb.toString());
					}
					
					fbList[i][j].clear();
					
					mTotal /= 5;
					sTotal /= size;
					int d;
					
					for(int k = 0; k < 4; k++) {
						// 방향이 모두 짝수, 홀수이면 (0, 2, 4, 6), 아니면 (1, 3, 5, 7)
						if(even != odd) {
							d = 0;
						} else {
							d = 1;
						}
						
						Fireball fb = new Fireball(i, j, mTotal, sTotal, d+=2*k, curMove);
						
						fbList[i][j].add(fb);
						
//						System.out.println("나눔: " + fb.toString());
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
	
	private static int modifyIdx(int n) {
		int m = 0;
		
		if(n > N) {
			m = n % N;
		} else if (n < 0) {
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
	boolean isMoved;
	
	public Fireball(int x, int y, int m, int s, int d, boolean isMoved) {
		this.x = x;
		this.y = y;
		this.m = m;
		this.s = s;
		this.d = d;
		this.isMoved = isMoved;
	}

	@Override
	public String toString() {
		return "Fireball [x=" + x + ", y=" + y + ", m=" + m + ", s=" + s + ", d=" + d + ", isMoved=" + isMoved + "]";
	}
}

