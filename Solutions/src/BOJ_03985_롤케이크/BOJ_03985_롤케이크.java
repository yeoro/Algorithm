package BOJ_03985_롤케이크;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_03985_롤케이크 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int N = sc.nextInt();
		
		int[] cake = new int[L+1];
		ArrayList<Integer> expect = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			
			int P = sc.nextInt();
			int K = sc.nextInt();
			int cnt = 0;
			
			// 각 방청객의 예상 조각
			expect.add(K-P+1);
			
			// 각 방청객이 원하는 조각 찜하기
			for(int j = P; j <= K; j++) {
				if(cake[j] == 0) {
					cake[j] = i;
					cnt++;
				}
			}
			
			// 각 방청객의 실제 조각
			result.add(cnt);
		}
		
		System.out.println(expect.indexOf(Collections.max(expect))+1);
		System.out.println(result.indexOf(Collections.max(result))+1);
		
		sc.close();
	}
}
