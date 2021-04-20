package BOJ_12865_Æò¹üÇÑ¹è³¶;

import java.io.*;
import java.util.*;

class Main {
	
	static ArrayList<Integer> temp = new ArrayList<Integer>();
	static Stuff[] stuff;
	static int[] dp;
	static int N, K, max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		stuff = new Stuff[N];
		dp = new int[101];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			stuff[i] = new Stuff(W, V);
			dp[W] = V;
		}
		
		solve(0);
		
		bw.write(max + "\n");
		
		br.close();
		bw.flush();
	}
	
	private static void solve(int weight) {
		if(weight > K) {
			return;
		}
		
		int sum = 0;
		for(int i : temp) {
			sum += stuff[i].v;
		}
		
		max = Math.max(max, sum);
		
		for(int i = 0; i < N; i++) {
			if(!temp.contains(i)) {
				temp.add(i);
				solve(weight + stuff[i].w);
				temp.remove(temp.size()-1);
			}
		}
	}
}

class Stuff {
	int w, v;

	public Stuff(int w, int v) {
		this.w = w;
		this.v = v;
	}
}

