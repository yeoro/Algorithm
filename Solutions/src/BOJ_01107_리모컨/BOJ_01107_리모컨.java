package BOJ_01107_������;

import java.util.Scanner;

public class BOJ_01107_������ {

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
		
		// +, - ��ư�� ������ ��찡 �ִ� ��ư�� ������ Ƚ���̹Ƿ� �ʱⰪ���� ����
		res = Math.abs(N - 100);
		
		// ù��° �ڸ����� ���峪�� ���� ���ڹ�ư�� ���� ���
		for(int i = 0; i < 10; i++) {
			if(button[i] != 1) {
				solve(1, i);
			}
		}
		
		System.out.println(res);
		sc.close();
	}
	
	private static void solve(int length, int channel) {
		if(length > Integer.toString(N).length()+1) { // �̵��Ϸ��� ä���� �ڸ����� ������ ����
			return;
		}
		
		int min = Math.abs(N - channel) + length;
		res = Math.min(min, res);
		
		for(int i = 0; i < 10; i++) { // ���� �ڸ� ��ư ����
			if(button[i] != 1) {
				solve(length+1, (channel*10)+i); // ���� ������ ��ư�� 10�� ���ϰ� ���� ���� �ڸ��� ���� ���� ����
			}
		}
		
	}
}

