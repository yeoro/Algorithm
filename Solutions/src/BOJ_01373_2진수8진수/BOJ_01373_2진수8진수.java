package BOJ_01373_2����8����;

import java.util.Scanner;

public class BOJ_01373_2����8���� {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String binary = sc.next();
		
		StringBuffer sb = new StringBuffer(binary);
		StringBuffer octal = new StringBuffer();
		
		sb.reverse();
		
		loop:for(int i = 0; i < sb.length(); i+=3) {
			
			// 3���� �ڸ� ���������� 10���� ��
			Long temp = (long) 0;
			
			for(int j = 0; j < 3; j++) {
				if(j+i == sb.length()) { // ���ڿ��� ���̸� ���� ������ 10���� ���� 8������ �߰�
					octal.append(temp);
					break loop;
				}
				
				// �ش� ���� 2������ 10���� ���� ����
				if(Long.parseLong(sb.charAt(j+i) + "") != 0) {
					Long l = j * Long.parseLong(sb.charAt(j+i) + "");
					temp += (int)Math.pow(2, l);
				}
			}
			
			// 10���� ���� 8������ �߰�
			octal.append(temp);
		}
		
		System.out.println(octal.reverse());
		
		sc.close();
	}
}

