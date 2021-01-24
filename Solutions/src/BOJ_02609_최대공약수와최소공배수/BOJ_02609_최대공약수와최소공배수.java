package BOJ_02609_�ִ��������ּҰ����;

import java.util.Scanner;

public class BOJ_02609_�ִ��������ּҰ���� {
	
	static int lcm;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		if(x > y) {
			go(x, y);
		} else {
			go(y, x);
		}
		
		System.out.println(lcm);
		System.out.println((x*y)/lcm);
		
		sc.close();
	}
	
	static void go(int x, int y) {
		
		if(x % y == 0) {
			lcm = y;
			return;
		}
		
		go(y, x%y);
	}
}

