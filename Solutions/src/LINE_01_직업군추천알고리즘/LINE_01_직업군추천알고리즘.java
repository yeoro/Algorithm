package LINE_01_직업군추천알고리즘;

import java.io.*;
import java.util.*;

public class LINE_01_직업군추천알고리즘 {
	
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
			
			// 현재 직업군
			String curJob = temp[0];
			// 현재 직업군에서의 선호도 점수
			int score = 0;
			
			for(int j = 1; j < temp.length; j++) { // 높은 점수부터 꺼냄
				for(int k = 0; k < languages.length; k++) { // 입력한 언어 값이랑 맞는지 확인
					if(temp[j].equals(languages[k])) { // 맞으면 점수 계산
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

