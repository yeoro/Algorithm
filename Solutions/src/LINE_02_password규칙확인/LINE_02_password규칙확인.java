package LINE_02_password��ĢȮ��;

import java.io.*;
import java.util.*;

public class LINE_02_password��ĢȮ�� {
	
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
			
			// 1. 8 �� password ���� �� 15
			if(!checkLength(password)) {
				violation[1] = true;
			}
			
			// 2. 4 ������ ���� �׷츸 ���� - ���ĺ� �빮��(A~Z), ���ĺ� �ҹ���(a~z), ����(0~9), Ư������(~!@#$%^&*)
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
			
			// 3. 4 ������ ���� �׷쿡�� 3 ���� �̻� ����
			int cnt = 0;
			
			for(int k = 0; k < 4; k++) {
				if(group[k]) {
					cnt++;
				}
			}
			
			if(cnt < 3) {
				violation[3] = true;
			}
			
			// 4. ���� ���ڰ� 4�� �̻� ���� X
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
			
			// 5. ���� ���ڰ� 5�� �̻� ���� X
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
			
			// ���� ��Ģ ���
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
	
	// ���� �Ǵ�
	private static boolean checkLength(String s) {
		return s.length() >= 8 && s.length() <= 15;
	}
	
	// �빮�� �Ǵ�
	private static int checkUpper(char c) {
		int num = c - '0';
		int result = 0;
		
		if(num >= 17 && num <= 42) {
			result = 1;
		}
		
		return result;
	}
	
	// �ҹ��� �Ǵ�
	private static int checkLower(char c) {
		int num = c - '0';
		int result = 0;
		
		if(num >= 49 && num <= 74) {
			result = 2;
		}
		
		return result;
	}
	
	// ���� �Ǵ�
	private static int checkNumber(char c) {
		int num = c - '0';
		int result = 0;
		
		if(num >= 0 && num <= 9) {
			result = 3;
		}
		
		return result;
	}
	
	// Ư������ �Ǵ�
	private static int checkSpecial(char c) {
		StringBuffer special = new StringBuffer("~!@#$%^&*");
		int result = 0;
		
		if(special.indexOf(c+"") != -1) {
			result = 4;
		}
		
		return result;
	}
}

