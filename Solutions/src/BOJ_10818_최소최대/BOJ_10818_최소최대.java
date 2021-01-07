package BOJ_10818_置社置企;

import java.util.Scanner;

public class BOJ_10818_置社置企 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		int max = -1000001;
		int min = 1000001;
		
		for (int tc = 0; tc < TC; tc++) {
		
			int num = sc.nextInt();
			
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		
		System.out.println(min + " " + max);
		
		
		sc.close();
	}

}
