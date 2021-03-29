package PG_2021KAKAO_�űԾ��̵���õ;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class PG_2021KAKAO_�űԾ��̵���õ {
	
	private static final Pattern REMOVE_CHAR_PATTERN = Pattern.compile("[^\\w-.]");
	private static final Pattern REMOVE_CONTINUEDDOT_PATTERN = Pattern.compile("[\\.]{2,}");
	private static final Pattern REMOVE_EDGEDOT_PATTERN = Pattern.compile("^[\\.]|[\\.]$");
	
	static String new_id = "...!@BaT#*..y.abcdefghijklm";
	
	public static void main(String[] args) {
		
		// 1�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.
		String answer = new_id.toLowerCase();
		
		// 2�ܰ� new_id���� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
		answer = removeChar(answer);
		
		// 3�ܰ� new_id���� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
		answer = removeContinuedDot(answer);
		
		// 4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
		answer = removeEdgeDot(answer);
				
		// 5�ܰ� new_id�� �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
		answer = insertA(answer);
		
		// 6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
		// ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
		answer = trimChar(answer);
		
		// 7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.
		answer = repeatChar(answer);
		
		System.out.println(answer);
	}
	
	private static String removeChar(String input) {
		return REMOVE_CHAR_PATTERN.matcher(input).replaceAll("");
	}
	
	private static String removeContinuedDot(String input) {
		return REMOVE_CONTINUEDDOT_PATTERN.matcher(input).replaceAll(".");
	}
	
	private static String removeEdgeDot(String input) {
		return REMOVE_EDGEDOT_PATTERN.matcher(input).replaceAll("");
	}
	
	private static String insertA(String input) {
		String output = input;
		
		if(output.length() == 0) {
			output += 'a';
		}
		
		return output;
	}
	
	private static String trimChar(String input) {
		String output = input;
		
		if(output.length() >= 16) {
			output = output.substring(0, 15);
		}
		
		return REMOVE_EDGEDOT_PATTERN.matcher(output).replaceAll("");
	}
	
	private static String repeatChar(String input) {
		String output = input;
		
		if(output.length() <= 2) {
			while(output.length() < 3) {
				output += output.charAt(output.length()-1);
			}
		}
		
		return output;
	}
}

