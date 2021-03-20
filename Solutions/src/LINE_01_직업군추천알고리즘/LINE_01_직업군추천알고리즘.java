package LINE_01_��������õ�˰���;

import java.io.*;
import java.util.*;

public class LINE_01_��������õ�˰��� {
	
	static String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#",
							 "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
							 "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
							 "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
							 "GAME C++ C# JAVASCRIPT C JAVA"};
//	static String[] languages1 = {"PYTHON", "C++", "SQL"};
//	static int[] preference1 = {7, 5, 5};
	static String[] languages = {"JAVA", "JAVASCRIPT"};
	static int[] preference = {7, 5};
	
	public static void main(String[] args) {
		ArrayList<Job> list = new ArrayList<Job>();
		int sum = Integer.MIN_VALUE;
		
		for(int i = 0; i < table.length; i++) {
			String[] temp = table[i].split(" ");
			
			// ���� ������
			String curJob = temp[0];
			// ���� ������������ ��ȣ�� ����
			int score = 0;
			
			for(int j = 1; j < temp.length; j++) { // ���� �������� ����
				for(int k = 0; k < languages.length; k++) { // �Է��� ��� ���̶� �´��� Ȯ��
					if(temp[j].equals(languages[k])) { // ������ ���� ���
						score += preference[k] * (6-j);
					}
				}
			}
			
			list.add(new Job(curJob, score));
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(0).name);
	}
}

class Job implements Comparable<Job>{
	String name;
	int score;
	
	public Job(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public int compareTo(Job o) {
		if(this.score == o.score) {
			return this.name.compareTo(o.name);
		}
		return o.score - this.score;
	}
}

