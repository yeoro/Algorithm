package BOJ_18429_근손실;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18429_근손실 {

	static int N, K, cnt;
	static int[] input, output;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		input = new int[N+1];
		output = new int[N+1];
		v = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		int i = 1;
		while(st.hasMoreTokens()) {
			input[i] = Integer.parseInt(st.nextToken());
			++i;
		}
		
		Arrays.sort(input);
		
		solve(0, 500);
		
		bw.write(cnt + "\n");
		
		br.close();
		bw.flush();
	}
	
	private static void solve(int depth, int weight) {
		if(depth == N) {
			cnt++;
		}
		
		for(int i = 1; i <= N; i++) {
			if(v[i]) {
				continue;
			}
			
			if(weight + input[i] - K < 500) {
				continue;
			} 
			
			v[i] = true;
			output[depth+1] = input[i];
			solve(depth+1, weight+input[i]-K);
			v[i] = false;
		}
		
	}
}

