package BOJ_10950_AB3;

import java.util.Scanner;

public class BOJ_10950_AB3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 0; tc < TC; tc++) {
		
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			System.out.println(A+B);
		}
		
		sc.close();
	}

}
