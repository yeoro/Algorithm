package BOJ_11721_��������������ϱ�;

import java.util.Scanner;

public class BOJ_11721_��������������ϱ� {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		int share = (int) (Math.ceil(s.length() / 10.0));
		
		for(int i = 0; i < share; i++) {
			
			if((i * 10) + 10 > s.length()) {
				System.out.println(s.substring(i * 10, s.length()));
			} else {
				System.out.println(s.substring(i * 10, (i * 10) + 10));
			}
			
		}
		
		sc.close();
	}

}
