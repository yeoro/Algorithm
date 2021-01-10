package BOJ_01592_영식이와친구들;

import java.util.Scanner;

public class BOJ_01592_영식이와친구들 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] player = new int[N+1];
		int i = 1; 
		int cnt = 0; // 공을 던진 횟수
		
		while(true) {
			player[i]++;
			
			// 공을 받은 횟수가 M이면 게임 종료
			if(player[i] == M) {
				System.out.println(cnt);
				break;
			}
			
			// 공을 받은 횟수가 홀수이면 시계 방향으로 L번째 있는 사람에게 전달
			if(player[i] % 2 != 0) {
				i+=L;
				
				if(i > N) {
					i-=N;
				}
				
				cnt++;
				continue;
			}
			
			// 공을 받은 횟수가 짝수이면 반시계 방향으로 L번째 있는 사람에게 전달
			if(player[i] % 2 == 0) {
				i-=L;
				
				if(i <= 0) {
					i+=N;
				}
				
				cnt++;
				continue;
			}
		}
		
		sc.close();
	}
}
