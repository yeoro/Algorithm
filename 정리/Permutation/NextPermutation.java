import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {

	static int[] arr;
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		do {
			System.out.println(Arrays.toString(arr));
		}while(np());
		
		sc.close();
	}
	
	private static boolean np() {
		// 꼭대기 찾기
		int i = N-1; // 맨 뒤부터 시작
		while(i > 0 && arr[i-1] >= arr[i]) { // 내림차순의 시작이 되면 꼭대기를 구한 것
			--i;
		}
		
		if(i == 0) { // 꼭대기가 맨 왼쪽이면 더 이상 만들 순열이 없음
			return false;
		}
		
		// 바꿀 수 찾기
		int j = N-1;
		while(arr[i-1] >= arr[j]) {
			--j;
		}
		
		// 바꾸기
		int temp = arr[j];
		arr[j] = arr[i-1];
		arr[i-1] = temp;
		
		// 뒤에 정렬
		int k = N-1;
		while(i < k) {
			temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
			--k;
			++i;
		}
		
		return true;
	}

}
