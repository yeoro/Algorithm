package BOJ_10872_���丮��;

import java.util.Scanner;

public class BOJ_10872_���丮�� {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(factorial(N));
		
		sc.close();
	}
	
	static int factorial(int n) {
		
		if(n <= 1) {
			return 1;
		}
		
		return n * factorial(n - 1);
	}
}

