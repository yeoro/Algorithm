package BOJ_10828_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>(); 
			
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			
			switch(st.nextToken()) {
				case "push":
					stack.add(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					if(stack.isEmpty()) {
						System.out.println("-1");
					} else {
						int pop = stack.pop();
						System.out.println(pop);
					}
					break;
				case "size":
					System.out.println(stack.size());
					break;
				case "empty":
					if(stack.isEmpty()) {
						System.out.println("1");
					} else {
						System.out.println("0");
					}
					break;
				case "top":
					if(stack.isEmpty()) {
						System.out.println("-1");
					} else {
						System.out.println(stack.peek());
					}
					break;
			}
		}
		br.close();
	}
}
