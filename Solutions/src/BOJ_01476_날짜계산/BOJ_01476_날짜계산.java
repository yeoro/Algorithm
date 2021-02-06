package BOJ_01476_날짜계산;

import java.util.Scanner;

public class BOJ_01476_날짜계산 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		
		int earth = 0;
		int sun = 0;
		int moon = 0;
		int year = 0;
		
		while(true) {
			
			++earth;
			++sun;
			++moon;
			++year;
			
			if(earth > 15) {
				earth = 1;
			}
			
			if(sun > 28) {
				sun = 1;
			}
			
			if(moon > 19) {
				moon = 1;
			}
			
			if(earth == E && sun == S && moon == M) {
				break;
			}
			
		}
		
		System.out.println(year);
		
		sc.close();
	}
}

