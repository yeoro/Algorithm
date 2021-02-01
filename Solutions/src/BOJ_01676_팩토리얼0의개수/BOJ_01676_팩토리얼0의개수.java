package BOJ_01676_팩토리얼0의개수;

import java.util.Scanner;

public class BOJ_01676_팩토리얼0의개수 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int five = 0;
		
		for(int i = N; i >= 1; i--) {
			if(i % 5 == 0) {
				five++;
			}
			
			if(i % 25 == 0) {
				five++;
			}
			
			if(i % 125 == 0) {
				five++;
			}
		}
		
		System.out.println(five);
		
		sc.close();
	}
}

