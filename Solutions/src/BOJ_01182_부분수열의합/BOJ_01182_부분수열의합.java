package BOJ_01182_�κм�������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_01182_�κм������� {
	
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
		// ���� �ʰ��� ����
		if(idx >= N) { 
			return;
		}
		sum += input[idx];
		
		if(sum == S) {
			result++;
		}
		
		// ���� �ε����� ���� ���� or �������� �ʴ� ���� Ž��
		solve(idx+1, sum-input[idx]);
		solve(idx+1, sum);
	}
}

