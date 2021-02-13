package BOJ_09095_123더하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_09095_123더하기 {
	
	static int[] nums;
	static int n, cnt, size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			cnt = 0;
			
			solve(0);
			
			bw.write(cnt + "\n");
		}
		
		
		br.close();
		bw.flush();
	}
	
	private static void solve(int sum) {
		if(sum > n) {
			return;
		}
			
		if(sum == n) {
			cnt++;
			return;
		}
		
		for(int i = 1; i <= 3; i++) {
			solve(sum+i);
		}
	}
}

