package BOJ_14502_楷备家;

import java.io.*;
import java.util.*;

public class BOJ_14502_楷备家 {
	
	static Queue<Node> vQ = new LinkedList<Node>();
	static Queue<Node> vTemp = new LinkedList<Node>();
	static ArrayList<Node> wList = new ArrayList<Node>();
	static ArrayList<Node> wTemp = new ArrayList<Node>();
	static int[][] lab, copy;
	static boolean[] vWall;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N, M, max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][M];
		copy = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				
				if(lab[i][j] == 2) {
					vQ.add(new Node(i, j));
				}
				
				if(lab[i][j] == 0) {
					wList.add(new Node(i, j));
				}
			}
		}
		
		vWall = new boolean[wList.size()];
		
		makeWall(0, 0);
		
		System.out.println(max);
		
		br.close();
	}
	
	private static void makeWall(int idx, int cnt) {
		if(cnt == 3) {
			copy();
			
			for(int i = 0; i < wTemp.size(); i++) {
				Node w = wTemp.get(i);
				
				copy[w.x][w.y] = 1; 
			}
			
			infection();
			
			int safe = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(copy[i][j] == 0) {
						safe++;
					}
				}
			}
			
			max = Math.max(safe, max);
			
			return;
		}
		
		for(int i = idx; i < wList.size(); i++) {
			if(!vWall[i]) {
				vWall[i] = true;
				wTemp.add(wList.get(i));
				makeWall(i, cnt+1);
				vWall[i] = false;
				wTemp.remove(wTemp.size()-1);
			}
		}
	}
	
	private static void copy() {
		for(int i = 0; i < lab.length; i++) {
			System.arraycopy(lab[i], 0, copy[i], 0, lab[i].length);
		}
		
		Iterator<Node> itr = vQ.iterator();
		while(itr.hasNext()) {
			vTemp.offer(itr.next());
		}
	}
	
	private static void infection() {
		while(!vTemp.isEmpty()) {
			Node virus = vTemp.poll();
			int x = virus.x;
			int y = virus.y;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(isIn(nx, ny) && copy[nx][ny] == 0) {
					copy[nx][ny] = 2;
					vTemp.add(new Node(nx, ny));
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}

class Node {
	int x, y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

