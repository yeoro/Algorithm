package BOJ_09019_DSLR;

import java.io.*;
import java.util.*;

public class BOJ_09019_DSLR {
	
	static boolean[] v;
	static int A, B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			v = new boolean[10000];
			
			solve();
		}
		
		br.close();
		bw.flush();
	}
	
	private static void solve() {
		Queue<Number> q = new LinkedList<Number>();
		q.add(new Number(A, ""));
		
		while(!q.isEmpty()) {
			Number n = q.poll();
			
			int num = n.num;
			String cmd = n.cmd;
			
			if(num == B) {
				System.out.println(cmd);
				return;
			}
			
			// D
			int D = (num * 2) % 10000;
			if(!v[D]) {
				v[D] = true;
				q.add(new Number(D, cmd + "D"));
			}
			
			// S
			int S = num == 0 ? 9999 : num-1;
			if(!v[S]) {
				v[S] = true;
				q.add(new Number(S, cmd + "S"));
			}
			
			// L
			int L = ((num % 1000) * 10) + (num / 1000);
			if(!v[L]) {
				v[L] = true;
				q.add(new Number(L, cmd + "L"));
			}

			// R
			int R = ((num % 10) * 1000) + (num / 10);
			if(!v[R]) {
				v[R] = true;
				q.add(new Number(R, cmd + "R"));
			}
		}
	}
}

class Number {
	int num;
	String cmd;
	
	public Number(int num, String cmd) {
		this.num = num;
		this.cmd = cmd;
	}
}

