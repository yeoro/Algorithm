package BOJ_01850_최대공약수;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_01850_최대공약수 {
	
	static Long lcm;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		Long A = sc.nextLong();
		Long B = sc.nextLong();

		if(A > B) {
			go(A, B);
		} else {
			go(B, A);
		}
		
		for(int i = 0; i < lcm; i++) {
			sb.append("1");
		}
		
		System.out.println(sb);
		
		sc.close();
	}
	
	static void go(Long x, Long y) {
		
		if(x % y == 0) {
			lcm = y;
			return;
		}
		
		go(y, x%y);
	}
}

