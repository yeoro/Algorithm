package BOJ_05014_스타트링크;

import java.io.*;
import java.util.*;

public class BOJ_05014_스타트링크 {
	
	static int[] startlink;
	static boolean[] v;
	static int F, S, G, U, D, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		startlink = new int[F+1];
		v = new boolean[F+1];
		
		bfs(S, 0);
		
		if(min == Integer.MAX_VALUE) {
			bw.write("use the stairs");
		} else {
			bw.write(min + "\n");
		}
		
		br.close();
		bw.flush();
	}
	
	private static void bfs(int cur, int cnt) {
		Queue<Floor> q = new LinkedList<Floor>();
		q.add(new Floor(cur, 0));
		v[cur] = true;
		
		while(!q.isEmpty()) {
			Floor f = q.poll();
			
			if(f.x == G) {
				min = Math.min(min, f.dis);
				return;
			}
			
			if(f.x + U <= F && !v[f.x + U]) {
				v[f.x + U] = true;
				q.add(new Floor(f.x+U, f.dis+1));
			}
			
			if(f.x - D > 0 && !v[f.x - D]) {
				v[f.x - D] = true;
				q.add(new Floor(f.x-D, f.dis+1));
			}
		}
	}
}

class Floor {
	int x, dis;

	public Floor(int x, int dis) {
		this.x = x;
		this.dis = dis;
	}
}

