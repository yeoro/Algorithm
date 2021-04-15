package BOJ_09328_열쇠;

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
					
					// 열지 못하는 문이라면 남은 문 리스트에 넣음
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
					// 빌딩 가장자리에서 접근할 수 있는 곳
					if(i == 0 || j == 0 || i == h-1 || j == w-1) {
						char c = map[i][j].charAt(0);
						
						if(!map[i][j].equals("*")) {
							if(map[i][j].equals(".") || door.containsKey(map[i][j])) { // 빈 공간 or 문
								go(i, j);
							} else if(c >= 'a' && c <= 'z') { // 열쇠이면 먹은 후 진행
								if(!door.containsKey(map[i][j].toUpperCase())) {
									door.put((c+"").toUpperCase(), true);
								}
								map[i][j] = ".";
								
								go(i, j);
							} else if(map[i][j].equals("$")) { // 문서면 먹은 후 진행
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
			
//			System.out.println("현재 위치: " + cur.x + " " + cur.y);
			for(int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(isIn(nx, ny) && !v[nx][ny]) {
					char c = map[nx][ny].charAt(0);
					
					// 빈 공간 or 열 수 있는 문이면 전진
					if(map[nx][ny].equals(".") || door.containsKey(map[nx][ny])) {
						v[nx][ny] = true;
						q.offer(new Node(nx, ny));
					} else if(c >= 'a' && c <= 'z') {
						String newKey = (c+"").toUpperCase();
						
						// 새 열쇠 저장
						if(!door.containsKey(newKey)) {
							door.put(newKey, true);
						}
						
						// 새로운 열쇠로 열 수 있는 문을 큐에 넣어줌
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

