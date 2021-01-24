package BOJ_10799_�踷���;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


public class BOJ_10799_�踷��� {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		
		String s = sc.next();
		
		int cnt = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);			
			if(c == '(') { // ( �̸� �ְ�
				stack.add(i);
			} else if(c == ')') { // ) �̸� peek�� �ε����� ���Ͽ� ���������� ��������� ����
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
