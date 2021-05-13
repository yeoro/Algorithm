package BOJ_21611_마법사상어와블리자드;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y +  "]";
		}
	}
	static LinkedList<Node> list = new LinkedList<Node>();
	static Node[] spell;
	static Node[] bead;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int[] res = new int[4];
	static int N, M, end;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		spell = new Node[M];
		bead = new Node[N*N];
		end = N*N;

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			spell[i] = new Node(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
		}
		
		bead[0] = new Node(N/2, N/2);
		
		int x = 0; int y = N-1;
		for(int i = 0; i < N/2; i++) {
			for(int j = i; j < y; j++) {
				list.addFirst(new Node(x, j));
			}
			
			for(int j = i; j < y; j++) {
				list.addFirst(new Node(j, y));
			}
			
			for(int j = y; j > i; j--) {
				list.addFirst(new Node(y, j));
			}
			
			for(int j = y; j > i; j--) {
				list.addFirst(new Node(j, x));
			}
			
			x++; y--;
		}
		list.addFirst(new Node(N/2, N/2));
		
		solve();
		
		br.close();
	}
	
	private static void solve() {
		for(int i = 0; i < M; i++) {
			cast(i);
			
			System.out.println("-----마법시전");
			for(int k = 0; k < N; k++) {
				for(int j = 0; j < N; j++) {
					System.out.print(map[k][j] + " ");
				}
				System.out.println();
			}
			
			move();
			
			System.out.println("-----빈자리이동");
			for(int k = 0; k < N; k++) {
				for(int j = 0; j < N; j++) {
					System.out.print(map[k][j] + " ");
				}
				System.out.println();
			}
			
			while(check()) {
				bomb();
				
				System.out.println("-----펑");
				for(int k = 0; k < N; k++) {
					for(int j = 0; j < N; j++) {
						System.out.print(map[k][j] + " ");
					}
					System.out.println();
				}
				move();
				
				System.out.println("-----빈자리이동");
				for(int k = 0; k < N; k++) {
					for(int j = 0; j < N; j++) {
						System.out.print(map[k][j] + " ");
					}
					System.out.println();
				}
			}
			
			divide();
			
		}
	}
	
	private static void cast(int idx) {
		Node curSpell = spell[idx];
		int d = curSpell.x; int s = curSpell.y;
		
		for(int i = 1; i <= s; i++) {
			int nx = N/2 + dx[d]*i;
			int ny = N/2 + dy[d]*i;
			
			res[map[nx][ny]]++;
			map[nx][ny] = 0;
		}
	}
	
	private static void move() {
		loop:for(int i = 1, size = list.size(); i < size; i++) {
			Node cur = list.get(i);
			int x = cur.x; int y = cur.y;
			
			if(map[x][y] == 0) {
				for(int j = i+1; j < size; j++) {
					Node next = list.get(j);
					int nx = next.x; int ny = next.y;
					
					if(map[nx][ny] != 0) {
						map[x][y] = map[nx][ny];
						map[nx][ny] = 0;
						
						continue loop;
					}
				}
			}
		}
	}
	
	private static boolean check() {
		int cnt = 1;
		
		for(int i = 1; i < list.size()-2; i++) {
			Node cur = list.get(i);
			int x = cur.x; int y = cur.y;
			
			Node next = list.get(i+1);
			int nx = next.x; int ny = next.y;
			
			if(map[x][y] != 0 && map[x][y] == map[nx][ny]) {
				cnt++;
				if(cnt >= 4) {
					return true;
				}
			} else {
				cnt = 1;
			}
		}
		
		return false;
	}
	
	private static void bomb() {
		ArrayList<Node> temp = new ArrayList<Node>();
		
		for(int i = 1; i < list.size()-2; i++) {
			temp.add(list.get(i));
			Node cur = list.get(i);
			int x = cur.x; int y = cur.y;
			
			Node next = list.get(i+1);
			int nx = next.x; int ny = next.y;
			
			if(map[x][y] != map[nx][ny]) {
				if(temp.size() >= 4) {
					for(Node n : temp) {
						res[map[n.x][n.y]]++;
						map[n.x][n.y] = 0;
					}
				}
				
				temp.clear();
			} 
		}
	}
	
	private static void divide() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for(int i = 1; i < list.size()-2; i++) {
			temp.add(i);
			Node cur = list.get(i);
			int x = cur.x; int y = cur.y;
			
			Node next = list.get(i+1);
			int nx = next.x; int ny = next.y;
			
			if(map[x][y] != map[nx][ny]) {
				if(temp.size() == 1) {
					int idx = temp.get(0);
					
					Node cnt = list.get(idx);
					Node num = list.get(idx+1);
				}

				
				temp.clear();
			} 
		}
	}
}

