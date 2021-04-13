package BOJ_17389_���ʽ�����;

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
			
			if(cur == 'O') { // ����
				score += i+1+bonus;
				bonus++;
			} else { // Ʋ��
				bonus = 0;
			}
		}
		
		System.out.println(score);
		
		br.close();
	}
}

