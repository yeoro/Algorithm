package PG_2021카카오인턴십_거리두기;

import java.io.*;
import java.util.*;

class Solution {
	
	static class Person {
		int x, y, partition, dis;

		public Person(int x, int y, int partition, int dis) {
			this.x = x;
			this.y = y;
			this.partition = partition;
			this.dis = dis;
		}

		@Override
		public String toString() {
			return "Person [x=" + x + ", y=" + y + ", partition=" + partition + ", dis=" + dis + "]";
		}
	}
	static char[][] pTemp;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N;
	static boolean check;
	
	public static void main(String[] args) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, 
							 {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
							 {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"},
							 {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
							 {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		int[] answer = new int[5];
		Arrays.fill(answer, 1);
		N = places.length;
		
		loop: for(int i = 0; i < N; i++) {
			pTemp = new char[N][N];

//			System.out.println("--------");
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					pTemp[j][k] = places[i][j].charAt(k);
				}
			}
			
//			for(int j = 0; j < N; j++) {
//				for(int k = 0; k < N; k++) {
//					System.out.print(pTemp[j][k] + " ");
//				}
//				System.out.println();
//			}
			
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					if(pTemp[j][k] == 'P') {
						check = true;
						v = new boolean[N][N];
						v[j][k] = true;
						bfs(j, k, 0, 0);
						
						if(!check) {
							answer[i] = 0;
							continue loop;
						}
//						System.out.println("--------" + check);
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(answer));
		
	}
	
	private static void bfs(int x, int y, int p, int d) {
		Queue<Person> q = new LinkedList<Person>();
		q.offer(new Person(x, y, p, d));
		
		
		while(!q.isEmpty()) {
			Person cur = q.poll();
			
			int cx = cur.x;
			int cy = cur.y;
			int partition = cur.partition;
			int dis = cur.dis;
			
			
			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(isIn(nx, ny) && !v[nx][ny]) {
					if(pTemp[nx][ny] == 'O') {
//						System.out.println(new Person(nx, ny, partition, dis+1).toString() + "O");
						v[nx][ny] = true;
						q.offer(new Person(nx, ny, partition, dis+1));
					}
					
					if(pTemp[nx][ny] == 'X') {
//						System.out.println(new Person(nx, ny, partition+1, dis+1).toString() + "X");
						v[nx][ny] = true;
						q.offer(new Person(nx, ny, partition+1, dis+1));
					}
					
					if(pTemp[nx][ny] == 'P') {
						if(dis+1 > 2) {
//							System.out.println(new Person(nx, ny, partition, dis+1).toString() + "P");
//							v[nx][ny] = true;
						} else if(dis+1 <= 2 && partition > 0) {
//							System.out.println(new Person(nx, ny, partition, dis+1).toString() + "P");
//							v[nx][ny] = true;
						} else {
							check = false;
//							System.out.println("check!");
							return;
						}
					}
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

