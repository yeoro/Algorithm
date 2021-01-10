package BOJ_08958_OX퀴즈;

import java.util.Scanner;

public class BOJ_08958_OX퀴즈 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 0; tc < TC; tc++) {
			int result = 0;
			int bonus = 0;
			char[] quiz = sc.next().toCharArray();
			
			for(int i = 0; i < quiz.length; i++) {
				
				if(quiz[i] == 'O') { // O 이면 1점
					result++;
					
					// 이전 퀴즈 맞았으면 보너스 1점
					if(i > 0 && quiz[i-1] == 'O') {
						bonus++;
					}
					result+=bonus;
				} else if(quiz[i] == 'X') { // X 이면 0점
					bonus = 0;
				}
			}
			
			System.out.println(result);
		}
		sc.close();
	}
}
