package BOJ_10817_세수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_10817_세수 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> num = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			num.add(sc.nextInt());
		}
		
		Collections.sort(num);
		
		System.out.println(num.get(1));
		
		sc.close();
	}
}
