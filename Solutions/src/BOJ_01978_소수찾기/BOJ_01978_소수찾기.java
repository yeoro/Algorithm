package BOJ_01978_�Ҽ�ã��;

import java.util.Scanner;

public class BOJ_01978_�Ҽ�ã�� {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int prime = 0;
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			boolean isPrime = true;
			
			if(num > 1) {
				for(int j = 2; j < num; j++) {
					if(num % j == 0) {
						isPrime = false;
						break;
					}
				}
				
				if(isPrime) {
					prime++;
				}
			}
		}
		
		System.out.println(prime);
		sc.close();
	}
}

