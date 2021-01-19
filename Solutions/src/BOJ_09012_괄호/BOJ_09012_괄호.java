package BOJ_09012_괄호;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


public class BOJ_09012_괄호 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 0; tc < TC; tc++) {
			Stack<Character> stack = new Stack<>();
			String s = sc.next();
			
			for(int i = 0; i < s.length(); i++) {
				
				if(s.charAt(i) == '(') {
					stack.push(s.charAt(i));
				} else if(s.charAt(i) == ')') {
					
					if(!stack.isEmpty()) { // 스택이 비어있지 않으면 있는걸 꺼내 판단 후 넣거나 뺌
						char c = stack.pop();
						
						if(c == ')') {
							stack.push(s.charAt(i));
							stack.push(c);
						} 
					} else { // 스택이 비어있으면 넣음
						stack.push(s.charAt(i));
					}
				}
			}
			
			if(stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
		sc.close();
	}
}
