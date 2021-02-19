package BOJ_07576_�丶��;

import java.io.*;
import java.util.*;

public class BOJ_07576_�丶�� {
	
	static Queue<Tomato> q = new LinkedList<Tomato>();
	static int[][] box;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int M, N, day, expect;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				
				box[i][j] = temp;
				
				if(temp == 1) {
					q.add(new Tomato(i, j));
				}
				
				if(temp == 0) { // ���� �丶�� ����
					expect++;
				}
			}
		}

		bfs();

		if(expect == 0 && day == 0) { // �丶�䰡 ��� �;��ִ� ���
			bw.write(0 + "\n");
		} else if(expect > 0) { // �丶�䰡 ��� ���� ���ϴ� ���
			bw.write(-1 + "\n");
		} else if(day > 0){ // �丶�䰡 ��� �ʹ� ��� �ϼ� 
			bw.write((day-1) + "\n"); 
		}

		br.close();
		bw.flush();
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			Tomato t = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				
				if(isIn(nx, ny) && isTomato(nx, ny)) {
					box[nx][ny] = box[t.x][t.y] + 1; // �丶�䰡 ���� �� ��� �ϼ��� ����
					q.add(new Tomato(nx, ny));
					
					day = Math.max(day, box[nx][ny]);
					expect--;
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
	
	private static boolean isTomato(int x, int y) {
		return box[x][y] == 0;
	}
}

class Tomato {
	int x, y;

	public Tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

