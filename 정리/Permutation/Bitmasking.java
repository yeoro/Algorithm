import java.util.Arrays;
import java.util.Scanner;

public class Bitmasking {
	
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
		
		permutation(0, 0);
		System.out.println("총 경우의 수 : " + totalCnt);
		
		sc.close();
	}
	
	private static void permutation(int cnt, int flag) { // cnt: 순열을 뽑는 자리
		if(cnt == R) { // 뽑으려던 개수를 다 뽑았으면 종료
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		
		// 해당 자리에 뽑을 가능한 모든 수에 대해 시도
		for(int i = 0; i < N; i++) {
			if((flag & 1<<i) != 0) { // 앞자리까지 선택된 수 배제
				continue;
			}
			
			number[cnt] = input[i];
			
			/*
			 *  flag 변수는 재귀 함수 안에 있는 로컬 변수이기 때문에 
			 *  함수가 실행 될 때마다 생겨서 서로 영향을 주지 않는다 -> 초기화 안해도 됨
			 */
			permutation(cnt+1, flag | 1<<i); // 다음자리의 수 뽑기
		}
	}
}
