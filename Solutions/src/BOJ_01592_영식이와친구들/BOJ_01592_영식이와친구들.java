package BOJ_01592_�����̿�ģ����;

import java.util.Scanner;

public class BOJ_01592_�����̿�ģ���� {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] player = new int[N+1];
		int i = 1; 
		int cnt = 0; // ���� ���� Ƚ��
		
		while(true) {
			player[i]++;
			
			// ���� ���� Ƚ���� M�̸� ���� ����
			if(player[i] == M) {
				System.out.println(cnt);
				break;
			}
			
			// ���� ���� Ƚ���� Ȧ���̸� �ð� �������� L��° �ִ� ������� ����
			if(player[i] % 2 != 0) {
				i+=L;
				
				if(i > N) {
					i-=N;
				}
				
				cnt++;
				continue;
			}
			
			// ���� ���� Ƚ���� ¦���̸� �ݽð� �������� L��° �ִ� ������� ����
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
