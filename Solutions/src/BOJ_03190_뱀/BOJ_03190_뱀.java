package BOJ_03190_뱀;

import java.io.*;
import java.util.*;

public class BOJ_03190_뱀 {

	static HashMap<Integer, String> dirHm = new HashMap<Integer, String>();
	static Deque<Snake> sDq = new LinkedList<Snake>();
	static int[][] board;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N, K, L;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		v = new boolean[N][N];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			board[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			dirHm.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		Snake start = new Snake(0, 0);
		sDq.offer(start);
		v[0][0] = true;
		
		dfs(3, 0);
		
		br.close();
	}
	
	private static void dfs(int dir, int time) {
		// 머리 위치
		int hx = sDq.peekFirst().x;
		int hy = sDq.peekFirst().y;
		
		// 꼬리 위치
		int tx = sDq.peekLast().x;
		int ty = sDq.peekLast().y;
		
		// 방향 변환
		int curDir = dir;
		if(dirHm.containsKey(time)) {
			switch(dirHm.get(time)) {
			case "D": // 오른쪽으로 90도 회전
				if(dir == 0) {
					curDir = 3;
				} else if(dir == 1) {
					curDir = 2;
				} else if(dir == 2) {
					curDir = 0;
				} else if(dir == 3) {
					curDir = 1;
				}
				break;
			case "L": // 왼쪽으로 90도 회전
				if(dir == 0) {
					curDir = 2;
				} else if(dir == 1) {
					curDir = 3;
				} else if(dir == 2) {
					curDir = 1;
				} else if(dir == 3) {
					curDir = 0;
				}
				break;
			}
		}
		
		// 이동할 위치
		int nx = hx + dx[curDir];
		int ny = hy + dy[curDir];
		
		if(isIn(nx, ny) && !v[nx][ny]) {
			if(board[nx][ny] == 0) { // 사과 안 먹고 이동
				// 머리 이동
				v[nx][ny] = true; 
				sDq.offerFirst(new Snake(nx, ny));
				
				// 꼬리 이동
				v[tx][ty] = false;
				sDq.pollLast();
				
				dfs(curDir, time+1);
			} else if(board[nx][ny] == 1) { // 사과 먹고 이동
				board[nx][ny] = 0;
				
				// 머리 이동
				v[nx][ny] = true; 
				sDq.offerFirst(new Snake(nx, ny));
				
				dfs(curDir, time+1);
			}
		} else if(!isIn(nx, ny) || v[nx][ny]) { // 벽이거나 자기 몸일 경우
			System.out.println(time+1);
			return;
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

class Snake {
	int x, y;

	public Snake(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
}

