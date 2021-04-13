package BOJ_17389_보너스점수;

import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String result = br.readLine();
		
		int score = 0;
		int bonus = 0;
		
		for(int i = 0; i < N; i++) {
			char cur = result.charAt(i);
			
			if(cur == 'O') { // 맞음
				score += i+1+bonus;
				bonus++;
			} else { // 틀림
				bonus = 0;
			}
		}
		
		System.out.println(score);
		
		br.close();
	}
}

