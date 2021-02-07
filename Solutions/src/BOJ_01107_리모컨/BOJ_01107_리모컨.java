package BOJ_01107_리모컨;

import java.util.Scanner;

public class BOJ_01107_리모컨 {

	static int[] button;
	static int N, cnt, res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M = sc.nextInt();
		button = new int[10];
		
		if(M > 0) {
			for(int i = 0; i < M; i++) {
				button[sc.nextInt()] = 1;
			}
		}
		
		// +, - 버튼만 눌렀을 경우가 최대 버튼을 누르는 횟수이므로 초기값으로 설정
		res = Math.abs(N - 100);
		
		// 첫번째 자리부터 고장나지 않은 숫자버튼을 누를 경우
		for(int i = 0; i < 10; i++) {
			if(button[i] != 1) {
				solve(1, i);
			}
		}
		
		System.out.println(res);
		sc.close();
	}
	
	private static void solve(int length, int channel) {
		if(length > Integer.toString(N).length()+1) { // 이동하려는 채널의 자릿수를 넘으면 종료
			return;
		}
		
		int min = Math.abs(N - channel) + length;
		res = Math.min(min, res);
		
		for(int i = 0; i < 10; i++) { // 다음 자리 버튼 선택
			if(button[i] != 1) {
				solve(length+1, (channel*10)+i); // 현재 선택한 버튼에 10을 곱하고 새로 생긴 자리에 다음 수를 넣음
			}
		}
		
	}
}

