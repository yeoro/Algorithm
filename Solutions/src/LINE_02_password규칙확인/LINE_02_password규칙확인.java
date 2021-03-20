package LINE_02_password규칙확인;

import java.io.*;
import java.util.*;

public class LINE_02_password규칙확인 {
	
	static String[] inp_str = {"AaTa+!12-3",
							   "aaaaZZZZ)",
							   "CaCbCgCdC888834A",
							   "UUUUU",
							   "ZzZz9Z824"};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list;

		for(int i = 0; i < inp_str.length; i++) {
			String password = inp_str[i];
			boolean[] violation = new boolean[6];
			boolean[] group = new boolean[5];
			
			// 1. 8 ≤ password 길이 ≤ 15
			if(!checkLength(password)) {
				violation[1] = true;
			}
			
			// 2. 4 종류의 문자 그룹만 포함 - 알파벳 대문자(A~Z), 알파벳 소문자(a~z), 숫자(0~9), 특수문자(~!@#$%^&*)
			for(int k = 0; k < password.length(); k++) {
				char c = password.charAt(k);
				
				if(checkUpper(c) == 0 && checkLower(c) == 0 && checkNumber(c) == 0 && checkSpecial(c) == 0) {
					violation[2] = true;
				}
				
				if(checkUpper(c) != 0) {
					group[checkUpper(c)] = true;
				}
				
				if(checkLower(c) != 0) {
					group[checkLower(c)] = true;
				}
				
				if(checkNumber(c) != 0) {
					group[checkNumber(c)] = true;
				}
				
				if(checkSpecial(c) != 0) {
					group[checkSpecial(c)] = true;
				}
			}
			
			// 3. 4 종류의 문자 그룹에서 3 종류 이상 포함
			int cnt = 0;
			
			for(int k = 0; k < 4; k++) {
				if(group[k]) {
					cnt++;
				}
			}
			
			if(cnt < 3) {
				violation[3] = true;
			}
			
			// 4. 같은 문자가 4개 이상 연속 X
			cnt = 1;
			
			for(int k = 0; k < password.length()-1; k++) {
				if(password.charAt(k) == password.charAt(k+1)) {
					cnt++;
					if(cnt == 4) {
						violation[4] = true;
						break;
					}
				} else {
					cnt = 1;
				}
			}
			
			// 5. 같은 문자가 5개 이상 포함 X
			String[] temp = new String[password.length()];
			temp = password.split("");
			Arrays.sort(temp);
			cnt = 1;
			
			for(int k = 0; k < temp.length-1; k++) {
				if(temp[k].equals(temp[k+1])) {
					cnt++;
					if(cnt == 5) {
						violation[5] = true;
						break;
					}
				} else {
					cnt = 1;
				}
			}
			
			// 위배 규칙 출력
			list = new ArrayList<Integer>();
			
			for(int k = 0; k < violation.length; k++) {
				if(violation[k]) {
					list.add(k);
				}
			}
			
			int[] result;
			
			if(list.size() == 0) {
				result = new int[1];
				result[0] = 0;
			} else {
				result = new int[list.size()];
				for(int k = 0; k < list.size(); k++) {
					result[k] = list.get(k);
				}
			}
			
			System.out.println(Arrays.toString(result));
		}

		br.close();
	}
	
	// 길이 판단
	private static boolean checkLength(String s) {
		return s.length() >= 8 && s.length() <= 15;
	}
	
	// 대문자 판단
	private static int checkUpper(char c) {
		int num = c - '0';
		int result = 0;
		
		if(num >= 17 && num <= 42) {
			result = 1;
		}
		
		return result;
	}
	
	// 소문자 판단
	private static int checkLower(char c) {
		int num = c - '0';
		int result = 0;
		
		if(num >= 49 && num <= 74) {
			result = 2;
		}
		
		return result;
	}
	
	// 숫자 판단
	private static int checkNumber(char c) {
		int num = c - '0';
		int result = 0;
		
		if(num >= 0 && num <= 9) {
			result = 3;
		}
		
		return result;
	}
	
	// 특수문자 판단
	private static int checkSpecial(char c) {
		StringBuffer special = new StringBuffer("~!@#$%^&*");
		int result = 0;
		
		if(special.indexOf(c+"") != -1) {
			result = 4;
		}
		
		return result;
	}
}

