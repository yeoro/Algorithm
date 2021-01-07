package BOJ_02439_º°Âï±â2;

import java.util.Scanner;

public class BOJ_02439_º°Âï±â2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1; tc <= TC; tc++) {
			for(int i = TC-tc; i > 0; i--) {
				System.out.print(" ");
			}
			for(int j = 1; j <= tc; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		sc.close();
	}
}
