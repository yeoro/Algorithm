package BOJ_01292_쉽게푸는문제;

import java.io.*;
import java.util.*;

public class BOJ_01292_쉽게푸는문제 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int num = 1;
		loop: while(true) {
			for(int i = 1; i <= num; i++) {
				list.add(num);
				if(list.size() == B) {
					break loop;
				}
			}
			num++;
		}
		
		int sum = 0;
		for(int i = A-1; i < B; i++) {
			sum += list.get(i);
		}
		
		System.out.println(sum);
		
		sc.close();
	}
}

