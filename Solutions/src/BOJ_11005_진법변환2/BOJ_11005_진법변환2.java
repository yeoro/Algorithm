package BOJ_11005_진법변환2;

import java.util.Scanner;

public class BOJ_11005_진법변환2 {
	
	static Long lcm;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		Long N = sc.nextLong();
		Long B = sc.nextLong();
		
		while(N > 0) {
			Long rest = N % B;
			
			if(rest >= 10) {
				char c = (char) (rest+55);
				sb.append(c);
			} else {
				sb.append(rest);
			}

			N = N / B;
		}
		
		System.out.println(sb.reverse());
		sc.close();
	}
}

