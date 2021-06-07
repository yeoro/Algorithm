package BOJ_21608_상어초등학교;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node implements Comparable<Node>{
		int x, y, cnt, zero;

		public Node(int x, int y, int cnt, int zero) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.zero = zero;
		}

		@Override
		public int compareTo(Node o) {
			if(Integer.compare(o.cnt, this.cnt) == 0) {
				if(Integer.compare(o.zero, this.zero) == 0) {
					if(Integer.compare(this.x, o.x) == 0) {
						return Integer.compare(this.y, o.y);
					}
					return Integer.compare(this.x, o.x);
				}
				return Integer.compare(o.zero, this.zero);
			}
			return Integer.compare(o.cnt, this.cnt);
		}
	}
	static int[][] room;
	static ArrayList<Integer>[] wants;
	static int[] order;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N, M, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = N*N;
		
		room = new int[N][N];
		wants = new ArrayList[M+1];
		order = new int[M+1];
		
		for(int i = 1; i <= M; i++) {
			wants[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			order[i] = Integer.parseInt(st.nextToken());
			
			while(st.hasMoreTokens()) {
				wants[order[i]].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		room[1][1] = order[1];
		
		for(int i = 2; i <= M; i++) {
			Node select = selectEmptySpace(i);
			
			room[select.x][select.y] = order[i];
		}
		
		res = calSatisfaction();
		
		System.out.println(res);
		
		br.close();
	}
	
	private static Node selectEmptySpace(int idx) {
		int cur = order[idx];
		
		PriorityQueue<Node> pq = new PriorityQueue<Main.Node>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
				if(room[i][j] == 0) {
					int cnt = 0;
					int zero = 0;
					
					for(int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						
						if(isIn(nx, ny)) {
							if(room[nx][ny] != 0) {
								if(wants[cur].contains(room[nx][ny])) {
									cnt++;
								}
							} else {
								zero++;
							}
						}
					}

					pq.add(new Node(i, j, cnt, zero));
				}
			}
		}
		
		return pq.peek();
	}
	
	private static int calSatisfaction() {
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int cnt = 0;

				for(int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if(isIn(nx, ny) && wants[room[i][j]].contains(room[nx][ny])) {
						cnt++;
					}
				}
				
				switch(cnt) {
				case 0:
					sum += 0;
					break;
				case 1:
					sum += 1;
					break;
				case 2:
					sum += 10;
					break;
				case 3:
					sum += 100;
					break;
				case 4:
					sum += 1000;
					break;
				}
			}
		}
		
		return sum;
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}