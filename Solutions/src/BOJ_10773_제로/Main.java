package BOJ_10773_Á¦·Î;

import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		int sum = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < K; i++) {
			int input = sc.nextInt();
			
			if(input != 0) {
				stack.add(input);
				sum += input;
			} else {
				sum -= stack.pop();
			}
		}
		
		System.out.println(sum);
		
		sc.close();
	}
}

