package BOJ_10845_ť;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10845_ť {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> q = new LinkedList<Integer>(); 
			
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			
			switch(st.nextToken()) {
				case "push":
					q.add(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					if(q.isEmpty()) {
						System.out.println("-1");
					} else {
						int poll = q.poll();
						System.out.println(poll);
					}
					break;
				case "size":
					System.out.println(q.size());
					break;
				case "empty":
					if(q.isEmpty()) {
						System.out.println("1");
					} else {
						System.out.println("0");
					}
					break;
				case "front":
					if(q.isEmpty()) {
						System.out.println("-1");
					} else {
						System.out.println(q.peekFirst());
					}
					break;
				case "back":
					if(q.isEmpty()) {
						System.out.println("-1");
					} else {
						System.out.println(q.peekLast());
					}
					break;
			}
		}
		br.close();
	}
}
