package BOJ_10870_피보나치수5;

import java.io.*;
import java.util.*;

public class BOJ_10870_피보나치수5 {
	
	static int[] arr;
	static int n, res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n+1];
		
		if(n == 0) {
			System.out.println(0);
		} else {
			arr[0] = 0;
			arr[1] = 1;

			fibo(2);
		}
		
		sc.close();
	}
	
	private static void fibo(int depth) {
		if(depth == n+1) {
			System.out.println(arr[n]);
			return;
		}
		
		arr[depth] = arr[depth-1] + arr[depth-2];
		fibo(depth+1);
	}
}

