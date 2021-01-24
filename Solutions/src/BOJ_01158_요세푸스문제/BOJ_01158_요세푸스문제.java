package BOJ_01158_요세푸스문제;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class BOJ_01158_요세푸스문제 {

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
		
		while(!list.isEmpty()) { // 리스트에 아무것도 없을 때 까지 반복
			for(int i = 0; i < K; i++) { // K번째 수를 찾기 위해 커서를 옮김
				if(!iter.hasNext()) { // 커서가 맨 오른쪽에 갔을 경우 커서의 위치를 맨 왼쪽으로 옮김
					iter = list.listIterator(0);
				} 
				
				if(i == K-1) {
					sb.append(iter.next());
					continue;
				}
				
				iter.next(); // 커서가 다음 요소를 선택
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
