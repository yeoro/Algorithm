package BOJ_01934_최소공배수;

import java.util.Scanner;

public class BOJ_01934_최소공배수 {
	
	static int lcm;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 0; tc < TC; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			if(A > B) {
				go(A, B);
			} else {
				go(B, A);
			}
			
			System.out.println((A*B)/lcm);
		}
		sc.close();
	}
	
	static void go(int x, int y) {
		
		if(x % y == 0) {
			lcm = y;
			return;
		}
		
		go(y, x%y);
	}
}

