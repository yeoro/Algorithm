package BOJ_10974_모든순열;

import java.io.*;
import java.util.*;

public class BOJ_10974_모든순열 {
	
	static ArrayList<Integer> p = new ArrayList<Integer>();
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		permutation(0);
		
		br.close();
		bw.flush();
	}
	
	private static void permutation(int depth) {
		if(depth == N) {
			for(int i : p) {
				System.out.print(i + " ");
			}
			System.out.println();
			
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!p.contains(i)) {
				p.add(i);
				permutation(depth+1);
				p.remove(p.size()-1);
			}
		}
	}
}

