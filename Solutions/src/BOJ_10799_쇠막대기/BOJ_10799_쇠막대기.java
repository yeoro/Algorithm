package BOJ_10799_쇠막대기;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


public class BOJ_10799_쇠막대기 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		
		String s = sc.next();
		
		int cnt = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);			
			if(c == '(') { // ( 이면 넣고
				stack.add(i);
			} else if(c == ')') { // ) 이면 peek의 인덱스와 비교하여 레이저인지 막대기인지 구분
				if(i - stack.peek() == 1) {
					stack.pop();
					cnt += stack.size();
				} else {
					cnt++;
					stack.pop();
				}
			}
		}
		
		System.out.println(cnt);
		
		sc.close();
	}
}
