package BOJ_02442_º°Âï±â5;

import java.util.Scanner;

public class BOJ_02442_º°Âï±â5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1; tc <= TC; tc++) {
			for(int i = TC-1; i >= tc; i--) {
				System.out.print(" ");
			}
			for(int j = 0; j < (tc*2)-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		sc.close();
	}
}
