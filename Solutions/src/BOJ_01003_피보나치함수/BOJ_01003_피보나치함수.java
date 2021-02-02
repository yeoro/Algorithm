package BOJ_01003_피보나치함수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_01003_피보나치함수 {
	
	static long[][] memo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		
		for(int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			memo = new long[41][2];
			
			memo[0][0] = 1;
			memo[0][1] = 0;
			memo[1][0] = 0;
			memo[1][1] = 1;
			
			memo[N][0] = fibo(N, 0);
			memo[N][1] = fibo(N, 1);
			
			bw.write(memo[N][0] + " " + memo[N][1] + "\n");
		}
		
		br.close();
		bw.flush();
	
	}
	
	private static long fibo(int n, int i) {
		if(n <= 1) {
			return memo[n][i];
		}
		
		if(memo[n][i] != 0) {
			return memo[n][i];
		}
		
		return memo[n][i] = fibo(n-1, i) + fibo(n-2, i);
	}
}

