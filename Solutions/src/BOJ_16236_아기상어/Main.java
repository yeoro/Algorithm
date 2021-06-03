package BOJ_16236_아기상어;

import java.io.*;
import java.util.*;

public class Main {

	static class Shark {
		int x, y, size, time, eat;

		public Shark(int x, int y, int size, int time, int eat) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.time = time;
			this.eat = eat;
		}
	}
	static class Fish implements Comparable<Fish> {
		int x, y, size, dis;

		public Fish(int x, int y, int size, int dis) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.dis = dis;
		}

		@Override
		public int compareTo(Fish o) {
			if(Integer.compare(this.dis, o.dis) == 0) {
				if(Integer.compare(this.x, o.x) == 0) {
					return Integer.compare(this.y, o.y);
				}
				return Integer.compare(this.x, o.x);
			}
			return Integer.compare(this.dis, o.dis);
		}
	}
	static Queue<Shark> sq = new LinkedList<Main.Shark>();
	static ArrayList<Fish> flist = new ArrayList<Main.Fish>();
	static int[][] sea;
	static boolean[][] v, tv;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		sea = new int[N][N];
		v = new boolean[N][N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for(int j = 0; j < N; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());

				if(sea[i][j] == 9) {
					sea[i][j] = 0;
					sq.offer(new Shark(i, j, 2, 0, 0));
				}

				if(sea[i][j] != 0 && sea[i][j] != 9) {
					flist.add(new Fish(i, j, sea[i][j], 0));
				}
			}
		}

		solve();

		br.close();
	}	

	private static void solve() {
		ArrayList<Fish> curLiveFish;

		while(!sq.isEmpty()) {
			curLiveFish = new ArrayList<Main.Fish>();
			
			Shark cur = sq.poll();
			int x = cur.x;
			int y = cur.y;
			int size = cur.size;
			int time = cur.time;
			int eat = cur.eat;

			for(Fish fish : flist) {
				if(sea[fish.x][fish.y] < size && !v[fish.x][fish.y]) {
					Queue<Shark> temp = new LinkedList<Main.Shark>();
					temp.offer(new Shark(x, y, size, 0, 0));
					tv = new boolean[N][N];
					
					while(!temp.isEmpty()) {
						Shark t = temp.poll();
						
						if(t.x == fish.x && t.y == fish.y) {
							Fish next = new Fish(fish.x, fish.y, sea[fish.x][fish.y], t.time);
							curLiveFish.add(next);
							break;
						}
						
						for(int i = 0; i < 4; i++) {
							int nx = t.x + dx[i];
							int ny = t.y + dy[i];
							
							if(isIn(nx, ny) && !tv[nx][ny] && sea[nx][ny] <= size) {
								tv[nx][ny] = true;
								temp.offer(new Shark(nx, ny, size, t.time+1, 0));
							}
						}
					}
				}
			}
			
			if(curLiveFish.size() == 0) {
				System.out.println(time);
				return;
			}
			
			Collections.sort(curLiveFish);

			Fish next = curLiveFish.get(0);
			v[next.x][next.y] = true;
			sea[next.x][next.y] = 0;
			
			if(eat+1 == size) {
				sq.offer(new Shark(next.x, next.y, size+1, time+next.dis, 0));
			} else {
				sq.offer(new Shark(next.x, next.y, size, time+next.dis, eat+1));
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}