package BOJ_01182_부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_01182_부분수열의합 {
	
	static int N, S, result;
	static int[] input;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		int idx = 0;
		while(st.hasMoreTokens()) {
			input[idx] = Integer.parseInt(st.nextToken());
			++idx;
		}
		
		Arrays.sort(input);
		
		solve(0, 0);
		
		System.out.println(result);
		br.close();
		
	}
	
	private static void solve(int idx, int sum) {
		// 범위 초과시 종료
		if(idx >= N) { 
			return;
		}
		sum += input[idx];
		
		if(sum == S) {
			result++;
		}
		
		// 다음 인덱스의 수를 선택 or 선택하지 않는 경우로 탐색
		solve(idx+1, sum-input[idx]);
		solve(idx+1, sum);
	}
}

