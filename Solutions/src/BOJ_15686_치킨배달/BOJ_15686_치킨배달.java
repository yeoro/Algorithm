package BOJ_15686_치킨배달;

import java.io.*;
import java.util.*;

public class BOJ_15686_치킨배달 {
	
	static ArrayList<Node> hl = new ArrayList<Node>();
	static ArrayList<Node> cl = new ArrayList<Node>();
	static boolean[] v;
	static int N, M, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				
				if(temp == 1) {
					hl.add(new Node(i, j));
				}
				if(temp == 2) {
					cl.add(new Node(i, j));
				}
			}
		}
		
		v = new boolean[cl.size()];
		
		chooseChicken(0, 0);
		
		bw.write(min + "\n");
		
		bw.flush();
		br.close();
	}
	
	private static void chooseChicken(int cur, int cnt) {
		if(cnt == M) {
			calDis();
			return;
		}
		
		for(int i = cur; i < cl.size(); i++) {
			v[i] = true;
			chooseChicken(i+1, cnt+1);
			v[i] = false;
		}
	}
	
	private static void calDis() {
		int totalDis = 0;
		
		for(int i = 0; i < hl.size(); i++) {
			Node h = hl.get(i);
			int hx = h.x;
			int hy = h.y;
			
			int curMin = Integer.MAX_VALUE;
			
			for(int j = 0; j < cl.size(); j++) {
				if(v[j]) {
					Node c = cl.get(j);
					int cx = c.x;
					int cy = c.y;

					int dis = Math.abs(hx - cx) + Math.abs(hy - cy);

					curMin = Math.min(curMin, dis);
				}
			}
			
			totalDis += curMin;
		}
		
		min = Math.min(totalDis, min);
	}
}

class Node {
	int x, y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

