package BOJ_10825_국영수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_10825_국영수 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		ArrayList<Student> list = new ArrayList<Student>();
		
		for(int i = 0; i < N; i++) {
			list.add(new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(list);
		
		for(Student s : list) {
			System.out.println(s.name);
		}
		
		sc.close();
	}
}

class Student implements Comparable<Student> {

	String name;
	int korean;
	int english;
	int math;
	
	public Student(String name, int korean, int english, int math) {
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.name = name;
	}

	@Override
	public int compareTo(Student o) {
		if(o.korean == this.korean) {
			if(o.english == this.english) {
				if(o.math == this.math) {
					return this.name.compareTo(o.name);
				}
				return o.math - this.math;
			}
			return this.english - o.english;
		}
		return o.korean - this.korean;
	}
	
}
