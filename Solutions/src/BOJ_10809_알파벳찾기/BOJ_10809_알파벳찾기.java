package BOJ_10809_¾ËÆÄºªÃ£±â;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10809_¾ËÆÄºªÃ£±â {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		String s = sc.next();
		
		int[] arr = new int[150];
		Arrays.fill(arr, -1);
		
		for(int i = 0; i < s.length(); i++) {
			if(arr[s.charAt(i)] == -1) {
				arr[s.charAt(i)] = i;
			}
		}
		
		for(int i = 'a'; i <= 'z'; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);
		
		sc.close();
	}
}
