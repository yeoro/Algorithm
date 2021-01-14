package BOJ_02750_�������ϱ�;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_02750_�������ϱ� {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		ArrayList<Long> list = new ArrayList<Long>();
		
		for(int i = 0; i < N; i++) {
			if(list.contains(i)) {
				continue;
			}
			list.add(sc.nextLong());
		}
		
		Collections.sort(list);
		
		for(Long i : list) {
			System.out.println(i);
		}
		
		sc.close();
	}
}

