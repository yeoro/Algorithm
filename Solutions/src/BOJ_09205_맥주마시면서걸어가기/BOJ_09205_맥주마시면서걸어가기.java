package BOJ_09205_맥주마시면서걸어가기;

import java.io.*;
import java.util.*;

public class BOJ_09205_맥주마시면서걸어가기 {
	
	static int[][] map;
	static int INF = 10000 * 100 + 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			// 거리 배열 초기화
			map = new int[n+2][n+2];
			for(int i = 0; i < n+2; i++) {
				for(int j = 0; j < n+2; j++) {
					map[i][j] = (i == j) ? 0 : INF;
				}
			}
			
			// 상근이네 위치
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Node SK = new Node(x, y);
			
			// 편의점 위치
			LinkedList<Node> CVS = new LinkedList<Node>();
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				CVS.add(new Node(x, y));
			}
			
			// 펜타포트 위치
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			Node Pentaport = new Node(x, y);
			
			// 상근이네에서 펜타포트까지 한 번에 갈 수 있는 경우
			int sToP = Math.abs(SK.x - Pentaport.x) + Math.abs(SK.y - Pentaport.y);
			if(sToP <= 1000) {
				bw.write("happy\n");
				continue;
			}
			
			for(int i = 0; i < CVS.size(); i++) {
				Node cvs = CVS.get(i);
					
				// 상근이네와 편의점과의 거리
				int sToC = Math.abs(SK.x - cvs.x) + Math.abs(SK.y - cvs.y);
				if(sToC <= 1000) {
					map[0][i+1] = Math.min(map[0][i+1], sToC);
				}

				// 편의점과 펜타포트 거리
				int cToP = Math.abs(Pentaport.x - cvs.x) + Math.abs(Pentaport.y - cvs.y);
				if(cToP <= 1000) {
					map[i+1][n+1] = Math.min(map[i+1][n+1], cToP); 
				}
				
				// 편의점 간의 거리
				for(int j = 0; j < CVS.size(); j++) {
					if(i != j) {
						Node cvs2 = CVS.get(j);
						
						int cToC = Math.abs(cvs.x - cvs2.x) + Math.abs(cvs.y - cvs2.y);
						
						if(cToC <= 1000) { // 갈 수 있는 거리인 경우만 경로 설정
							map[j+1][i+1] = Math.min(map[j+1][i+1], cToC);
						}
					}
				}
			}
			
			// 플로이드 와샬
			for(int k = 0; k < n+2; k++) {
				for(int i = 0; i < n+2; i++) {
					for(int j = 0; j < n+2; j++) {
						map[j][i] = map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
			}
			
			if(map[0][n+1] != INF) {
				bw.write("happy\n");
			} else {
				bw.write("sad\n");
			}
		}
		
		br.close();
		bw.flush();
	}
}

class Node {
	int x, y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
