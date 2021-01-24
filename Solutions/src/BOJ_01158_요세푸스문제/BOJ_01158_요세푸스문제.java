package BOJ_01158_�似Ǫ������;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class BOJ_01158_�似Ǫ������ {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer("<");
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		List<Integer> list = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(i+1);
		}
		
		ListIterator<Integer> iter = list.listIterator();
		
		while(!list.isEmpty()) { // ����Ʈ�� �ƹ��͵� ���� �� ���� �ݺ�
			for(int i = 0; i < K; i++) { // K��° ���� ã�� ���� Ŀ���� �ű�
				if(!iter.hasNext()) { // Ŀ���� �� �����ʿ� ���� ��� Ŀ���� ��ġ�� �� �������� �ű�
					iter = list.listIterator(0);
				} 
				
				if(i == K-1) {
					sb.append(iter.next());
					continue;
				}
				
				iter.next(); // Ŀ���� ���� ��Ҹ� ����
			}
			
			iter.remove();
			if(list.isEmpty()) {
				sb.append(">");
			} else {
				sb.append(", ");
			}
			
		}
		
		System.out.println(sb);
		
		
		sc.close();
	}
	
}
