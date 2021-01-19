package BOJ_10820_문자열분석;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_10820_문자열분석 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);

		while(sc.hasNextLine()) {
			
			int lower = 0;
			int upper = 0;
			int num = 0;
			int blank = 0;
			
			String s = sc.nextLine();
			
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) >= 97 && s.charAt(i) <= 122) {
					lower++;
				} else if(s.charAt(i) >= 65 && s.charAt(i) <= 90) {
					upper++;
				} else if(s.charAt(i) >= 48 && s.charAt(i) <= 57) {
					num++;
				} else {
					blank++;
				}
			}
			
			System.out.println(lower + " " + upper + " " + num + " " + blank);
		}
		
		sc.close();
		
	}
}
