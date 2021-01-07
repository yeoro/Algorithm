package BOJ_02446_º°Âï±â9;

import java.util.Scanner;

public class BOJ_02446_º°Âï±â9 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int line = (N * 2) - 1;
		
		int star = line - 1;
		int blank = 0;
		
		for(int i = 1; i <= line; i++) {
			
			for(int j = 0; j < blank; j++) {
				System.out.print(" ");
			}
			
			for(int j = 0; j <= star; j++) {
				System.out.print("*");
			}
			
			System.out.println();
			
			if(i <= line / 2) {
				blank++;
				star-=2;
			} else {
				blank--;
				star+=2;
			}
			
		}
		sc.close();
	}
}
