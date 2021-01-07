package BOJ_02440_º°Âï±â3;

import java.util.Scanner;

public class BOJ_02440_º°Âï±â3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 0; tc < TC; tc++) {
			for(int i = TC; i > tc; i--) {
				System.out.print("*");
			}
			System.out.println();
		}

		sc.close();
	}
}
