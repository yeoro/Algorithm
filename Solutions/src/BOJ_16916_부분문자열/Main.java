package BOJ_16916_부분문자열;

import java.io.*;
import java.util.*;

class Main {
	
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int[] p;
	static String S, P;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		P = br.readLine();
		
		p = new int[P.length()];
		
		setArr();
		
		KMP();
		
		if(list.size() != 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		
		br.close();
	}
	
	private static void setArr() {
		for(int i = 1, j = 0; i < P.length(); i++) {
			while(j > 0 && P.charAt(i) != P.charAt(j)) {
				j = p[j - 1];
			}
			
			if(P.charAt(i) == P.charAt(j)) {
				p[i] = ++j;
			}
		}
	}
	
	private static void KMP() {
		for(int i = 0, j = 0; i < S.length(); i++) {
			while(j > 0 && P.charAt(j) != S.charAt(i)) {
				j = p[j-1];
			}
			
			if(P.charAt(j) == S.charAt(i)) {
				if(j == P.length()-1) {
					list.add(i - j);
					
					j = p[j];
				} else {
					j++;
				}
			}
		}
	}
}

