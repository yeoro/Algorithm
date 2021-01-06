package BOJ_10953_AB6;

import java.util.Scanner;

public class BOJ_10953_AB6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 0; tc < TC; tc++) {
			
			String s = sc.next();
			
			String[] num = s.split(",");
			
			System.out.println(Integer.parseInt(num[0]) + Integer.parseInt(num[1]));
		}
		
		sc.close();
	}
}
