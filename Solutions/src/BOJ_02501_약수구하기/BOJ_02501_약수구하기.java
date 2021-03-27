package BOJ_02501_약수구하기;

import java.io.*;
import java.util.*;

public class BOJ_02501_약수구하기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		ArrayList<Integer> div = new ArrayList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			if(N % i == 0 && !div.contains(i)) {
				div.add(i);
			}
		}
		
		if(div.size() < K) {
			System.out.println(0);
		} else if(div.size() >= K) {
			System.out.println(div.get(K-1));
		}
		
		sc.close();
	}
}

