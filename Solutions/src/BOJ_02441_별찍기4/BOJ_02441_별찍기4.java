package BOJ_02441_º°Âï±â4;

import java.util.Scanner;

public class BOJ_02441_º°Âï±â4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 0; tc < TC; tc++) {
			for(int i = 0; i < tc; i++) {
				System.out.print(" ");
			}
			for(int j = TC; j > tc; j--) {
				System.out.print("*");
			}
			System.out.println();
		}

		sc.close();
	}
}
