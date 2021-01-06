package BOJ_11720_숫자의합;

import java.util.Scanner;

public class BOJ_11720_숫자의합 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		String s = sc.next();
		
		int sum = 0;
		
		for(int i = 0; i < num; i++) {
			
			sum += Integer.parseInt(s.charAt(i) + "");
		}
		
		System.out.println(sum);
		
		sc.close();
	}
}
