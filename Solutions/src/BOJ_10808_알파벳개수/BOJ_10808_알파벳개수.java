package BOJ_10808_¾ËÆÄºª°³¼ö;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_10808_¾ËÆÄºª°³¼ö {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		String s = sc.next();
		
		int[] arr = new int[150];
		
		for(int i = 0; i < s.length(); i++) {
			arr[s.charAt(i)]++;
		}
		
		for(int i = 'a'; i <= 'z'; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);
		
		sc.close();
	}
}
