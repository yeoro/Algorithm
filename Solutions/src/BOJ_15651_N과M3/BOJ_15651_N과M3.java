package BOJ_15651_N��M3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15651_N��M3 {
	
	static int N, M;
	static int[] input, output;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N+1];
		output = new int[M+1];
		
		for(int i = 1; i <= N; i++) {
			input[i] = i;
		}
		
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
			output[depth+1] = input[i];
			permutation(depth+1);
		}
	}
}

