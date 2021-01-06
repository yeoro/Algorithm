package BOJ_11022_AB8;

import java.util.Scanner;

public class BOJ_11022_AB8 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1; tc <= TC; tc++) {
			
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			System.out.println("Case #" + tc + ": " + A + " + " + B + " = " + (A+B));
		}
		
		sc.close();
	}

}
