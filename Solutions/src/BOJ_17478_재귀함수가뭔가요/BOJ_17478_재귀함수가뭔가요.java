package BOJ_17478_����Լ���������;

import java.util.Scanner;

public class BOJ_17478_����Լ��������� {
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		
		go(0);
		
		sc.close();
	}
	
	static void go(int n) {
		for(int i = 0; i < n; i++) {
			System.out.print("____");
		}
		System.out.println("\"����Լ��� ������?\"");
		
		if(n == N) {
			for(int i = 0; i < n; i++) {
				System.out.print("____");
			}
			System.out.println("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			for(int i = 0; i < n; i++) {
				System.out.print("____");
			}
			System.out.println("��� �亯�Ͽ���.");
			return;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print("____");
		}
		System.out.println("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
		for(int i = 0; i < n; i++) {
			System.out.print("____");
		}
		System.out.println("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
		for(int i = 0; i < n; i++) {
			System.out.print("____");
		}
		System.out.println("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
		
		go(n+1);
		
		for(int i = 0; i < n; i++) {
			System.out.print("____");
		}
		System.out.println("��� �亯�Ͽ���.");
		return;
				
	}
}

