package BOJ_01212_8진수2진수;

import java.util.Scanner;

public class BOJ_01212_8진수2진수 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		String[] binary = {"000", "001", "010", "011", "100", "101", "110", "111"};
		
		String s = sc.next();
		boolean checkOne = false;
		
		for(int i = 0; i < s.length(); i++) {
			sb.append(binary[Integer.parseInt(s.charAt(i) + "")]);
			if(Integer.parseInt(s.charAt(i) + "") != 0) {
				checkOne = true;
			}
		}
		
		if(checkOne) {
			while(sb.charAt(0) == '0') {
				sb.deleteCharAt(0);
			}
			System.out.println(sb);
		} else if(!checkOne) {
			System.out.println(0);
		}
		
		sc.close();
	}
}

