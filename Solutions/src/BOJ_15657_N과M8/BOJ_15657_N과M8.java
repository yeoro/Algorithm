package BOJ_15657_N°úM8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657_N°úM8 {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static int[] input, output;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N+1];
		output = new int[M+1];
		
		st = new StringTokenizer(br.readLine());
		
		int i = 1;
		while(st.hasMoreTokens()) {
			input[i] = Integer.parseInt(st.nextToken());
			++i;
		}
		
		Arrays.sort(input);
		
		permutation(0);
		
		br.close();
		bw.flush();
	}
	
	private static void permutation(int depth) throws IOException {
		if(depth == M) {
			for(int i = 1; i <= M; i++) {
				bw.write(output[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(output[depth] <= input[i]) {
				output[depth+1] = input[i];
				permutation(depth+1);
			}
		}
	}
}

