package BOJ_01759_암호만들기;

import java.io.*;
import java.util.*;

class Main {
	
	static char[] code;
	static char[] alphabet;
	static int L, C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alphabet = new char[C];
		code = new char[L];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alphabet);
		
		solve(0, 0, 0, 0);
		
		br.close();
	}
	
	private static void solve(int depth, int idx, int c, int v) {
		if(depth > L) {
			return;
		}
		
		if(depth == L) {
			if(v >= 1 && c >= 2) {
				StringBuilder sb = new StringBuilder();

				for(char e : code) {
					sb.append(e);
				}
				
				System.out.println(sb.toString());
			}
			
			return;
		}
		
		for(int i = idx; i < C; i++) {
			code[depth] = alphabet[i];
			if(isVowel(alphabet[i])) {
				solve(depth+1, i+1, c, v+1);
			} else {
				solve(depth+1, i+1, c+1, v);
			}
		}
	}
	
	private static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
}

