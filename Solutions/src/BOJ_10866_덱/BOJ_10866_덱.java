package BOJ_10866_��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10866_�� {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new LinkedList<Integer>(); 
			
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			
			switch(st.nextToken()) {
				case "push_front":
					deque.addFirst(Integer.parseInt(st.nextToken()));
					break;
				case "push_back":
					deque.addLast(Integer.parseInt(st.nextToken()));
					break;
				case "pop_front":
					if(deque.isEmpty()) {
						System.out.println("-1");
					} else {
						int poll = deque.pollFirst();
						System.out.println(poll);
					}
					break;
				case "pop_back":
					if(deque.isEmpty()) {
						System.out.println("-1");
					} else {
						int poll = deque.pollLast();
						System.out.println(poll);
					}
					break;
				case "size":
					System.out.println(deque.size());
					break;
				case "empty":
					if(deque.isEmpty()) {
						System.out.println("1");
					} else {
						System.out.println("0");
					}
					break;
				case "front":
					if(deque.isEmpty()) {
						System.out.println("-1");
					} else {
						System.out.println(deque.peekFirst());
					}
					break;
				case "back":
					if(deque.isEmpty()) {
						System.out.println("-1");
					} else {
						System.out.println(deque.peekLast());
					}
					break;
			}
		}
		br.close();
	}
}
