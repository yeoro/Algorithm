import java.util.Arrays; 
import java.util.Scanner;

public class BooleanArray {
	
	static int N, R;
	static int[] input, number; // input: 입력된 수 | number: 완성된 수열 저장
	static boolean[] isSelected; // 수가 선택되었는지 판단
	static int totalCnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		isSelected = new boolean[N];
		number = new int[R];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		permutation(0);
		System.out.println("총 경우의 수 : " + totalCnt);
		
		sc.close();
	}
	
	private static void permutation(int cnt) { // cnt: 순열을 뽑는 자리
		if(cnt == R) { // 뽑으려던 개수를 다 뽑았으면 종료
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		
		// 해당 자리에 뽑을 가능한 모든 수에 대해 시도
		for(int i = 0; i < N; i++) {
			if(isSelected[i]) { // 앞자리까지 선택된 수 배제
				continue;
			}
			
			isSelected[i] = true;
			number[cnt] = input[i];
			permutation(cnt+1); // 다음자리의 수 뽑기
			isSelected[i] = false; // 다음자리에 다른 수를 뽑기 위해 선택처리 해제
		}
	}
}
