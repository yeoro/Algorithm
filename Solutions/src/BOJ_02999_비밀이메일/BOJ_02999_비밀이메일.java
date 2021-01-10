package BOJ_02999_����̸���;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_02999_����̸��� {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		int N = s.length();
		int R = 0;
		int C = 0;
		
		// R�� C ���ϱ�
		for(int i = 1; i <= N; i++) {
			if(N % i == 0) {
				if(i <= N/i) {
					R = Math.max(R, i);
					C = N/R;
				}
			}
		}
		
		char[][] message = new char[R][C]; // �����̰� ������ �޽��� �迭
		
		List<Character> m = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			m.add(s.charAt(i));
		}
		
		for(int i = 0; i < C; i++) {
			for(int j = 0; j < R; j++) {
				message[j][i] = m.get(0);
				m.remove(0);
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(message[i][j]);
			}
		}
		
		sc.close();
	}
}
