package PG_2021KAKAO_신규아이디추천;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class PG_2021KAKAO_신규아이디추천 {
	
	private static final Pattern REMOVE_CHAR_PATTERN = Pattern.compile("[^\\w-.]");
	private static final Pattern REMOVE_CONTINUEDDOT_PATTERN = Pattern.compile("[\\.]{2,}");
	private static final Pattern REMOVE_EDGEDOT_PATTERN = Pattern.compile("^[\\.]|[\\.]$");
	
	static String new_id = "...!@BaT#*..y.abcdefghijklm";
	
	public static void main(String[] args) {
		
		// 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
		String answer = new_id.toLowerCase();
		
		// 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
		answer = removeChar(answer);
		
		// 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		answer = removeContinuedDot(answer);
		
		// 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		answer = removeEdgeDot(answer);
				
		// 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		answer = insertA(answer);
		
		// 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
	    // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		answer = trimChar(answer);
		
		// 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
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

