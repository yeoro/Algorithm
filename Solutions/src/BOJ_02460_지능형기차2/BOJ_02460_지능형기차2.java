package BOJ_02460_지능형기차2;

import java.io.*;
import java.util.*;

public class BOJ_02460_지능형기차2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int max = Integer.MIN_VALUE;
		int people = 0;
		
		for(int i = 0; i < 10; i++) {
			int in = sc.nextInt();
			int out = sc.nextInt();
			
			people += out - in;
			
			max = Math.max(people, max);
		}
		
		System.out.println(max);
		
		sc.close();
	}
}

