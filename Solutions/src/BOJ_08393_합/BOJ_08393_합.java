package BOJ_08393_��;

import java.util.Scanner;

public class BOJ_08393_�� {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int result = 0;
		
		for(int i = 1; i <= n; i++) {
			result += i;
		}
		
		System.out.println(result);
		
		sc.close();
	}
	
}
