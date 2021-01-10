package BOJ_11399_ATM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_11399_ATM {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 0;
		
		ArrayList<Integer> time = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			time.add(sc.nextInt());
		}
		
		Collections.sort(time);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				result += time.get(j);
			}
		}
		
		System.out.println(result);
		sc.close();
	}
}
