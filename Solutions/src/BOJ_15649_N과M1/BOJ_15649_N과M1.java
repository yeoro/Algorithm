package BOJ_15649_N°úM1;

import java.util.Scanner;

public class BOJ_15649_N°úM1 {
	
	static int N, M;
	static int[] input, output;
	static boolean[] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		input = new int[N+1];
		v = new boolean[N+1];
		output = new int[M+1];
		
		for(int i = 1; i <= N; i++) {
			input[i] = i;
		}
		
		permutation(0);
		
		sc.close();
	}
	
	private static void permutation(int depth) {
		if(depth == M) {
			for(int i = 1; i <= M; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(v[i]) {
				continue;
			}
			
			output[depth+1] = input[i];
			v[i] = true;
			permutation(depth+1);
			v[i] = false;
		}
	}
}

