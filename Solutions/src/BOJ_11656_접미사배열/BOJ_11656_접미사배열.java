package BOJ_11656_접미사배열;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_11656_접미사배열 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		List<String> suffix = new ArrayList<>();
		
		for(int i = 0; i < s.length(); i++) {
			StringBuffer sb = new StringBuffer();
			
			for(int j = i; j < s.length(); j++) {
				sb.append(s.charAt(j));
			}
			
			suffix.add(sb.toString());
		}
		
		Collections.sort(suffix);
		
		for(String string : suffix) {
			System.out.println(string);
		}
		
		sc.close();
	}
	
}
