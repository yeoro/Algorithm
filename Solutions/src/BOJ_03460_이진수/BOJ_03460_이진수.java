package BOJ_03460_이진수;

import java.io.*;
import java.util.*;

public class BOJ_03460_이진수 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb;
		
		int TC = sc.nextInt();
		
		for(int tc = 0; tc < TC; tc++) {
			int n = sc.nextInt();

			sb = new StringBuffer(Integer.toBinaryString(n));
			
			sb = sb.reverse();
			
			for(int i = 0; i < sb.length(); i++) {
				if(sb.charAt(i) == '1') {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
		
		sc.close();
	}
}

