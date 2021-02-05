/*
 * 	조합
 * 		{a, b, c} -> {a, b}, {a, c}, {b, c}
 * 
 * 	3C2 -> 2C1(3번째 원소 선택), 2C2(선택X)
 * 	2C1 -> 1C0(더 이상 뽑을 게 없을 때 재귀 멈춤), 1C1
 *  2C2 -> 1C1, 1C2(1개에서 2개를 뽑지 못하므로 재귀 멈춤)
 */

import java.util.Arrays;
import java.util.Scanner;

public class Combination {
	
	static int N, R;
	static int[] input, number; // input: 입력된 수 | number: 완성된 수열 저장
	static int totalCnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		R = sc.nextInt();

		input = new int[N];
		number = new int[R];

		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		combination(N, R);
		System.out.println(totalCnt);
		
		sc.close();
	}
	
	// n번째 원소(순서)를 r위치(순서)에 조합해보기
	private static void combination(int n, int r) {
		// 다 뽑음
		if(r == 0) {
			++totalCnt;
			System.out.println(Arrays.toString(number));
			return;
		}
		
		// 조합이 불가능한 경우
		if(n < r) {
			return;
		}
		
		
		// 선택
		number[r-1] = input[n-1]; // number 배열의 r-1 위치에 input 배열의 n-1번째 원소 저장
		combination(n-1, r-1); // n-1Cr-1 
		
		// 비선택
		combination(n-1, r);
		
	}
}
