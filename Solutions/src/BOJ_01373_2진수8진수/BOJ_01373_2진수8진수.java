package BOJ_01373_2진수8진수;

import java.util.Scanner;

public class BOJ_01373_2진수8진수 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String binary = sc.next();
		
		StringBuffer sb = new StringBuffer(binary);
		StringBuffer octal = new StringBuffer();
		
		sb.reverse();
		
		loop:for(int i = 0; i < sb.length(); i+=3) {
			
			// 3개씩 자른 구간마다의 10진수 값
			Long temp = (long) 0;
			
			for(int j = 0; j < 3; j++) {
				if(j+i == sb.length()) { // 문자열의 끝이면 지금 까지의 10진수 값을 8진수에 추가
					octal.append(temp);
					break loop;
				}
				
				// 해당 구간 2진수의 10진수 값을 구함
				if(Long.parseLong(sb.charAt(j+i) + "") != 0) {
					Long l = j * Long.parseLong(sb.charAt(j+i) + "");
					temp += (int)Math.pow(2, l);
				}
			}
			
			// 10진수 값을 8진수에 추가
			octal.append(temp);
		}
		
		System.out.println(octal.reverse());
		
		sc.close();
	}
}

