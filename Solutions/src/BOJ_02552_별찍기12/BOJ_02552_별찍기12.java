package BOJ_02552_º°Âï±â12;

import java.util.Scanner;

public class BOJ_02552_º°Âï±â12 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int line = (N * 2) - 1;
		
		int blank = N - 1;
		int star = 1;
		
		for(int i = 1; i <= line; i++) {
			
			for(int j = 0; j < blank; j++) {
				System.out.print(" ");
			}
			
			for(int j = 0; j < star; j++) {
				System.out.print("*");
			}
			
			System.out.println();
			
			if(i <= line / 2) {
				star++;
				blank--;
			} else {
				star--;
				blank++;
			}
			
		}
		sc.close();
	}
}
