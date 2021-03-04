package BOJ_04179_��;

import java.io.*;
import java.util.*;

public class BOJ_04179_�� {
	
	static char[][] maze;
	static int[][] v; // ���̳� ���� -1, �� ������ 0, �����̴� 1 �� ���� ���¸� ��Ÿ���� ���� boolean�� �ƴ� int �迭 ���
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int R, C, res;
	static Queue<Node> fq, jq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		maze = new char[R][C];
		v = new int[R][C];
		fq = new LinkedList<Node>();
		jq = new LinkedList<Node>();
		
		for(int i = 0; i < R; i++) {
			String temp = br.readLine();
			for(int j = 0; j < C; j++) {
				maze[i][j] = temp.charAt(j);
				
				if(maze[i][j] == 'F') {
					v[i][j] = -1;
					fq.add(new Node(i, j, 0));
				}
				
				if(maze[i][j] == 'J') {
					v[i][j] = 1;
					jq.add(new Node(i, j, 1));
				}
				
				if(maze[i][j] == '#') {
					v[i][j] = -1;
				}
			}
		}
		
		bfs();
		
		if(res == 0) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(res);
		}
		
		br.close();
	}
	
	private static void bfs() {
		while(!jq.isEmpty()) { // �������� Ż�� ���θ� �Ǵ��ϱ� ���� ������ ť�� ����� ������ BFS Ž�� ����
			
			// �� ���� �̵�
			for(int i = 0, size = fq.size(); i < size; i++) {
				Node fire = fq.poll();
				
				int x = fire.x;
				int y = fire.y;
				
				for(int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					// ������ ���� ���� �� & ���̳� ���� �ƴ� ���
					if(isIn(nx, ny) && v[nx][ny] != -1) {
						v[nx][ny] = -1;
						fq.add(new Node(nx, ny, 0));
					}
				}
			}
			
			// ���� �̵�
			for(int i = 0, size = jq.size(); i < size; i++) {
				Node jihun = jq.poll();
				
				int x = jihun.x;
				int y = jihun.y;
				int time = jihun.time;
				
				for(int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(isIn(nx, ny) && v[nx][ny] == 0) { // ������ ���� ���� �� & �� ������ ���
						v[nx][ny] = 1;
						jq.add(new Node(nx, ny, time+1));
					} else if(!isIn(nx, ny)) { // ������ ���� ���� ���̸� Ż��
						res = time;
						return;
					}
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}

class Node {
	int x, y, time;

	public Node(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

