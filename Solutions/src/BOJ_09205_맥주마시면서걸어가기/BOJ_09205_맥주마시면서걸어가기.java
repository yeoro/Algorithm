package BOJ_09205_���ָ��ø鼭�ɾ��;

import java.io.*;
import java.util.*;

public class BOJ_09205_���ָ��ø鼭�ɾ�� {
	
	static int[][] map;
	static int INF = 10000 * 100 + 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			// �Ÿ� �迭 �ʱ�ȭ
			map = new int[n+2][n+2];
			for(int i = 0; i < n+2; i++) {
				for(int j = 0; j < n+2; j++) {
					map[i][j] = (i == j) ? 0 : INF;
				}
			}
			
			// ����̳� ��ġ
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Node SK = new Node(x, y);
			
			// ������ ��ġ
			LinkedList<Node> CVS = new LinkedList<Node>();
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				CVS.add(new Node(x, y));
			}
			
			// ��Ÿ��Ʈ ��ġ
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			Node Pentaport = new Node(x, y);
			
			// ����̳׿��� ��Ÿ��Ʈ���� �� ���� �� �� �ִ� ���
			int sToP = Math.abs(SK.x - Pentaport.x) + Math.abs(SK.y - Pentaport.y);
			if(sToP <= 1000) {
				bw.write("happy\n");
				continue;
			}
			
			for(int i = 0; i < CVS.size(); i++) {
				Node cvs = CVS.get(i);
					
				// ����̳׿� ���������� �Ÿ�
				int sToC = Math.abs(SK.x - cvs.x) + Math.abs(SK.y - cvs.y);
				if(sToC <= 1000) {
					map[0][i+1] = Math.min(map[0][i+1], sToC);
				}

				// �������� ��Ÿ��Ʈ �Ÿ�
				int cToP = Math.abs(Pentaport.x - cvs.x) + Math.abs(Pentaport.y - cvs.y);
				if(cToP <= 1000) {
					map[i+1][n+1] = Math.min(map[i+1][n+1], cToP); 
				}
				
				// ������ ���� �Ÿ�
				for(int j = 0; j < CVS.size(); j++) {
					if(i != j) {
						Node cvs2 = CVS.get(j);
						
						int cToC = Math.abs(cvs.x - cvs2.x) + Math.abs(cvs.y - cvs2.y);
						
						if(cToC <= 1000) { // �� �� �ִ� �Ÿ��� ��츸 ��� ����
							map[j+1][i+1] = Math.min(map[j+1][i+1], cToC);
						}
					}
				}
			}
			
			// �÷��̵� �ͼ�
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
