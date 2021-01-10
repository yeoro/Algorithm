package BOJ_03985_������ũ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_03985_������ũ {

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
			
			// �� ��û���� ���� ����
			expect.add(K-P+1);
			
			// �� ��û���� ���ϴ� ���� ���ϱ�
			for(int j = P; j <= K; j++) {
				if(cake[j] == 0) {
					cake[j] = i;
					cnt++;
				}
			}
			
			// �� ��û���� ���� ����
			result.add(cnt);
		}
		
		System.out.println(expect.indexOf(Collections.max(expect))+1);
		System.out.println(result.indexOf(Collections.max(result))+1);
		
		sc.close();
	}
}
