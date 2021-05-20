package BOJ_14620_²É±æ;

import java.io.*;
import java.util.*;

class Main {
	
	static class Node {
		int x, y, price;

		public Node(int x, int y, int price) {
			this.x = x;
			this.y = y;
			this.price = price;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", price=" + price + "]";
		}
	}
	static ArrayList<Node> grounds = new ArrayList<Node>();
	static ArrayList<Node> gComb = new ArrayList<Node>();
	static int[][] garden;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static boolean[] gv;
	static int N, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		garden = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < N; j++) {
				garden[i][j] = Integer.parseInt(st.nextToken());
				
				if(i != 0 && j != 0 && i != N-1 && j != N-1) {
					grounds.add(new Node(i, j, garden[i][j]));
				}
			}
		}
		
		gv = new boolean[grounds.size()];
		
		plant(0, 0);
		
		System.out.println(min);
		
		br.close();
	}
	
	private static void plant(int idx, int cnt) {
		if(cnt == 3) {
			v = new boolean[N][N];
			int sum = 0;
			
			for(Node n : gComb) {
				int temp = garden[n.x][n.y];
				v[n.x][n.y] = true;
				
				for(int i = 0; i < 4; i++) {
					int nx = n.x + dx[i];
					int ny = n.y + dy[i];
					
					if(!v[nx][ny]) {
						v[nx][ny] = true;
						temp += garden[nx][ny];
					} else {
						return;
					}
				}
				
				sum += temp;
			}
			
			min = Math.min(min, sum);
			
			return;
		}
		
		for(int i = idx; i < grounds.size(); i++) {
			if(!gv[i]) {
				gv[i] = true;
				gComb.add(grounds.get(i));
				plant(i+1, cnt+1);
				gv[i] = false;
				gComb.remove(gComb.size()-1);
			}
		}
	}
}

