package BOJ_10814_나이순정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_10814_나이순정렬 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		ArrayList<User> list = new ArrayList<User>();
		
		for(int i = 0; i < N; i++) {
			list.add(new User(i+1, sc.nextInt(), sc.next()));
		}
		
		Collections.sort(list);
		
		for(User u : list) {
			System.out.println(u.age + " " + u.name);
		}
		
		sc.close();
	}
}

class User implements Comparable<User> {
	
	int no;
	int age;
	String name;

	public User(int no, int age, String name) {
		super();
		this.no = no;
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(User o) {
		if(this.age - o.age == 0) {
			return this.no - o.no;
		}
		return this.age - o.age;
	}
	
}
