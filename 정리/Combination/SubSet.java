package day04_subset;

import java.util.Scanner;

public class SubSet {

	static int N, totalCnt;
	static int[] input, number;
	static boolean[] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		input = new int[N];
		v = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubSet(0);
		
		System.out.println("총 경우의 수: " + totalCnt);
		
		sc.close();
	}
	
	private static void generateSubSet(int cnt) {
		if(cnt == N) {
			totalCnt++;
			for(int i = 0; i < N; i++) {
				System.out.print((v[i] ? input[i] : "X") + " ");
			}
			System.out.println();
			return;
		}
		
		// 부분집합에 현재 원소를 선택
		v[cnt] = true;
		generateSubSet(cnt+1);
		
		// 부분집합에 현재 원소를 비선택
		v[cnt] = false;
		generateSubSet(cnt+1);
	}

}
