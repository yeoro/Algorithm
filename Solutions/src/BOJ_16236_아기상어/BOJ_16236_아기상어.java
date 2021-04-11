package BOJ_16236_�Ʊ���;

import java.io.*;
import java.util.*;

public class BOJ_16236_�Ʊ��� {
	
	static int[][] sea;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int N, time;
	
	static ArrayList<Node> fList = new ArrayList<Node>();
	static Queue<Node> sQ = new LinkedList<Node>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		sea = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				
				sea[i][j] = input;
				
				if(input != 0 && input != 9) {
					fList.add(new Node(i, j, input));
				}
				
				if(input == 9) {
					sQ.offer(new Node(i, j, 2, 0));
				}
			}
		}
		
		if(fList.size() == 0) {
			System.out.println(time);
		} else if (fList.size() == 1){
			int fx = fList.get(0).x;
			int fy = fList.get(0).y;
			int sx = sQ.peek().x;
			int sy = sQ.peek().y;
			
			System.out.println(Math.abs(fx - sx) + Math.abs(fy - sy));
		} else {
			solve();
			System.out.println(time);
		}
		
		br.close();
	}
	
	private static void solve() {
		while(fList.size() > 0) {
			Node shark = sQ.poll();
			
			System.out.println("���� ��� -> " + shark.toString());
			
			ArrayList<Node> eat = new ArrayList<Node>();
			int minDis = Integer.MAX_VALUE;
			
			// ���� ����� �Ÿ� ���
			for(Node fish : fList) {
				if(fish.size < shark.size) {
					int dis = Math.abs(shark.x - fish.x) + Math.abs(shark.y - fish.y);
					
					if(minDis > dis) {
						minDis = dis;
					}
				}
			}
			
			// ���� ����� ����� ����
			for(Node fish : fList) {
				int dis = Math.abs(shark.x - fish.x) + Math.abs(shark.y - fish.y);
				
				if(fish.size < shark.size && dis == minDis) {
					eat.add(fish);
				}
			}
			
			// ������ �����̹Ƿ� ���� �տ� �ִ� ����Ⱑ ��ǥ
			if(eat.size() > 0) {
				Node fish = eat.get(0);
				
				System.out.println("��ǥ -> " + fish.toString());
				
				// ������ �������� �� �� �ִ��� �Ǵ�
				if(move(shark, fish)) {
					time += Math.abs(shark.x - fish.x) + Math.abs(shark.y - fish.y);
					
					fList.remove(fish);
					sea[fish.x][fish.y] = 9;
					sea[shark.x][shark.y] = 0; 
					
					for(int i = 0; i < N; i++) {
						for(int j = 0; j < N; j++) {
							System.out.print(sea[i][j] + " ");
						}
						System.out.println();
					}
					
					if(shark.size == shark.cnt+1) { // ���� �� ũ�⸸ŭ ����⸦ �Ծ��ٸ� ũ�� ����
						sQ.offer(new Node(fish.x, fish.y, shark.size+1, 0));
					} else if(shark.size > shark.cnt+1) {
						sQ.offer(new Node(fish.x, fish.y, shark.size, shark.cnt+1));
					}
					
					System.out.println("������� �ð� -> " + time);
				} else {
					return;
				}
			} else {
				return;
			}
		}
	}
	
	private static boolean move(Node shark, Node fish) {
		Queue<Node> mvQ = new LinkedList<Node>();
		mvQ.offer(shark);
		v = new boolean[N][N];
		v[shark.x][shark.y] = true; 
		
		while(!mvQ.isEmpty()) {
			Node cur = mvQ.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				// ����� ũ��� ���� �����ų� �� ĭ�� ��� �̵�
				if(isIn(nx, ny) && !v[nx][ny]) {
					if(nx == fish.x && ny == fish.y) {
						System.out.println("����");
						return true;
					}
					
					if(sea[nx][ny] == cur.size || sea[nx][ny] == 0) {
						v[nx][ny] = true;
						
						Node mvS = new Node(nx, ny, shark.size);
						
						System.out.println("�̵� " + mvS.toString());
						mvQ.offer(mvS);
					}
				}
			}
		}
		
		return false;
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

class Node implements Comparable<Node>{
	int x, y, size, cnt;

	public Node(int x, int y, int size, int cnt) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.cnt = cnt;
	}

	public Node(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + ", size=" + size + ", cnt=" + cnt + "]";
	}

	@Override
	public int compareTo(Node o) {
		if(this.x == o.x) {
			return this.y - o.y;
		}
		return this.x - o.x;
	}
}

