package BOJ_09093_단어뒤집기;

import java.util.Scanner;

public class BOJ_09093_단어뒤집기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		sc.nextLine();
		
		for(int tc = 0; tc < TC; tc++) {
			String s = sc.nextLine();
			
			String[] arr = s.split(" ");
			
			for(int i = 0; i < arr.length; i++) {
				StringBuffer sb = new StringBuffer(arr[i]);
				
				System.out.print(sb.reverse() + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
	
}

