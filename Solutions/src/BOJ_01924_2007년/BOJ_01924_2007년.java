package BOJ_01924_2007³â;

import java.util.Calendar;
import java.util.Scanner;

public class BOJ_01924_2007³â {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2007);
		cal.set(Calendar.MONTH, x-1);
		cal.set(Calendar.DATE, y);
		
		int result = cal.get(Calendar.DAY_OF_WEEK);
		
		switch (result) {
			case 1: {
				System.out.println("SUN");
				break;
			}
			case 2: {
				System.out.println("MON");
				break;
			}
			case 3: {
				System.out.println("TUE");
				break;
			}
			case 4: {
				System.out.println("WED");
				break;
			}
			case 5: {
				System.out.println("THU");
				break;
			}
			case 6: {
				System.out.println("FRI");
				break;
			}
			case 7: {
				System.out.println("SAT");
				break;
			}
		}
		
		sc.close();
	}
	
}
