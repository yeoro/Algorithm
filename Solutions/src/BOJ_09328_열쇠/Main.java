package BOJ_09328_����;

import java.io.*;
import java.util.*;

class Main {
	
	static HashMap<String, Boolean> door;
	static HashMap<String, ArrayList<Node>> leftDoor;
	static String[][] map;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int h, w, doc;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			map = new String[h][w];
			v = new boolean[h][w];
			door = new HashMap<String, Boolean>();
			leftDoor = new HashMap<String, ArrayList<Node>>();
			doc = 0;
			
			for(int i = 0; i < h; i++) {
				String input = br.readLine();
				for(int j = 0; j < w; j++) {
					map[i][j] = input.charAt(j)+"";
				}
			}
			
			String key = br.readLine();
			
			if(key.charAt(0) != 0) {
				for(int i = 0; i < key.length(); i++) {
					door.put((key.charAt(i)+"").toUpperCase(), true);
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					char c = map[i][j].charAt(0);
					
					// ���� ���ϴ� ���̶�� ���� �� ����Ʈ�� ����
					if((c >= 'A' && c <= 'Z') && !door.containsKey(map[i][j])) {
						if(!leftDoor.containsKey(map[i][j])) {
							leftDoor.put(map[i][j], new ArrayList<Node>());
							leftDoor.get(map[i][j]).add(new Node(i, j));
						} else {
							leftDoor.get(map[i][j]).add(new Node(i, j));
						}
					}
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					// ���� �����ڸ����� ������ �� �ִ� ��
					if(i == 0 || j == 0 || i == h-1 || j == w-1) {
						char c = map[i][j].charAt(0);
						
						if(!map[i][j].equals("*")) {
							if(map[i][j].equals(".") || door.containsKey(map[i][j])) { // �� ���� or ��
								go(i, j);
							} else if(c >= 'a' && c <= 'z') { // �����̸� ���� �� ����
								if(!door.containsKey(map[i][j].toUpperCase())) {
									door.put((c+"").toUpperCase(), true);
								}
								map[i][j] = ".";
								
								go(i, j);
							} else if(map[i][j].equals("$")) { // ������ ���� �� ����
								doc++;
								map[i][j] = ".";
								
								go(i, j);
							}
						}
					}
				}
			}

			System.out.println(doc);
		}
		
		
		br.close();
		
	}
	
	private static void go(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(x, y));
		v[x][y] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
//			System.out.println("���� ��ġ: " + cur.x + " " + cur.y);
			for(int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(isIn(nx, ny) && !v[nx][ny]) {
					char c = map[nx][ny].charAt(0);
					
					// �� ���� or �� �� �ִ� ���̸� ����
					if(map[nx][ny].equals(".") || door.containsKey(map[nx][ny])) {
						v[nx][ny] = true;
						q.offer(new Node(nx, ny));
					} else if(c >= 'a' && c <= 'z') {
						String newKey = (c+"").toUpperCase();
						
						// �� ���� ����
						if(!door.containsKey(newKey)) {
							door.put(newKey, true);
						}
						
						// ���ο� ����� �� �� �ִ� ���� ť�� �־���
						for(Map.Entry<String, ArrayList<Node>> elem : leftDoor.entrySet()) {
							if(elem.getKey().equals(newKey)) {
								for(Node n : elem.getValue()) {
									q.offer(new Node(n.x, n.y));
								}
							}
						}
						
						map[nx][ny] = ".";
						v[nx][ny] = true;
					} else if(map[nx][ny].equals("$")) {
						doc++;
						map[nx][ny] = ".";
						v[nx][ny] = true;
						q.offer(new Node(nx, ny));
					}
				} 
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < h && y < w;
	}
}

class Node {
	int x, y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

