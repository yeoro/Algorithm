package BOJ_02745_진법변환;

import java.util.Scanner;

public class BOJ_02745_진법변환 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String N = sc.next();
		int B = sc.nextInt();
		
		System.out.println(Long.parseLong(N, B));
		
		sc.close();
	}
}

