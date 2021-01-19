package BOJ_11004_K번째수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_11004_K번째수 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		
		ArrayList<Long> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(sc.nextLong());
		}
		
		Collections.sort(list);

		int cnt = 1;
		int maxCnt = 1;
		Long maxNum = list.get(0);
		
		for(int i = 1; i < list.size(); i++) {
			if(list.get(i-1).equals(list.get(i))) {
				cnt++;
			} else {
				cnt = 1;
			}
			
			if(maxCnt < cnt) {
				maxCnt = cnt;
				maxNum = list.get(i);
			}
		}
		
		System.out.println(maxNum);
		
		sc.close();
	}
}
