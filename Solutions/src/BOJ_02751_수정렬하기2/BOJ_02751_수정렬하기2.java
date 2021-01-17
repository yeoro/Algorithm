package BOJ_02751_수정렬하기2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_02751_수정렬하기2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}
		
		Collections.sort(list);
		
		for(int i : list) {
			sb.append(i + "\n");
		}
		
		System.out.println(sb);
		sc.close();
	}
}

