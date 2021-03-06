package BOJ_15650_N��M2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15650_N��M2 {
	
	static int[] input, output;
	static boolean[] v;
	static int N, M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N+1];
		v = new boolean[N+1];
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
			if(v[i]) {
				continue;
			}
			
			if(output[depth] < input[i]) {
				v[i] = true;
				output[depth+1] = input[i];
				permutation(depth+1);
				v[i] = false;
			}
		}
	}
}

