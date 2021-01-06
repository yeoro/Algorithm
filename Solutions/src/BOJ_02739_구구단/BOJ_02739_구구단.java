package BOJ_02739_备备窜;

import java.util.Scanner;

public class BOJ_02739_备备窜 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i = 1; i <= 9; i++) {
			System.out.println(N + " * " + i + " = " + (N * i));
		}
		
		sc.close();
	}

}
