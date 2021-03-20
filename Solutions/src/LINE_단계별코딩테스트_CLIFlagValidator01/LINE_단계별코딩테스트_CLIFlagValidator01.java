package LINE_단계별코딩테스트_CLIFlagValidator01;

import java.io.*;
import java.util.*;

public class LINE_단계별코딩테스트_CLIFlagValidator01 {
	
	static String program = "line";
	static String[] flag_rules = {"-s STRING", 
								  "-n NUMBER", 
								  "-e NULL"};
	static String[] commands = {"line -n 100 -s hi -e", 
								"lien -s Bye"};
	static HashMap<String, String> hm = new HashMap<String, String>();
	
	public static void main(String[] args) {
		// 결과 배열을 true 값으로 초기화 한 후, 유효성 검사 하나라도 통과하지 못하면 false 값으로 바꿔줍니다.
		boolean[] answer = new boolean[commands.length];
		Arrays.fill(answer, true);
		
		// flag의 이름과 flag가 받아야 하는 인자의 종류 한 쌍으로 묶어 정의하기 위해 HashMap을 사용했습니다.
		StringTokenizer st;
		for(int i = 0; i < flag_rules.length; i++) {
			st = new StringTokenizer(flag_rules[i], " ");
			hm.put(st.nextToken(), st.nextToken());
		}
		
		for(int i = 0; i < commands.length; i++) {
			// 입력된 명령어를 공백을 기준으로 나누어 배열로 만듭니다.
			String[] cmd = commands[i].split(" ");
			
			// 명령어의 맨 앞에 있는 program 이름의 유효성을 검사합니다.
			String pg = program;
			if(!checkProgram(cmd[0], pg)) {
				answer[i] = false;
			}
			
			// 명령어를 꺼내며 '-'로 시작하면 flag_name, 그렇지 않으면 flag_argument로 판단합니다.
			String flag_name = "";
			String flag_argument_type = "";
			for(int j = 1; j < cmd.length; j++) {
				if(cmd[j].charAt(0) == '-') { // flag_name
					// flag_name이 유효하다면 다음에 오는 flag_argument를 검사하기 위해 flag_rules를 저장합니다.
					if(checkFlagName(cmd[j])) { 
						flag_name = cmd[j];
						flag_argument_type = hm.get(cmd[j]);
					} else {
						answer[i] = false;
						break;
					}
				} else { // flag_argument
					// 대응하는 flag가 없는 flag_argument가 없는지 검사합니다.
					if(flag_name.equals("")) {
						answer[i] = false;
						break;
					}
					
					String flag_argument = cmd[j];
					// 대응하는 flag가 요구하는 flag_argument_type인지 검사합니다.
					switch(flag_argument_type) {
					case "STRING":
						if(!flag_argument.getClass().getSimpleName().equals("String")) {
							answer[i] = false;
						}
						break;
					case "NUMBER":
						try {
							Integer.parseInt(flag_argument);
						} catch (Exception e) {
							answer[i] = false;
						}
						break;
					case "NULL":
						// NULL type은 인자를 필요로하지 않으므로 다음 flag의 유효성 검사를 위해 flag 상태를 초기화해줍니다.
						flag_name = "";
						flag_argument_type = "";
						break;
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(answer));
	}
	
	private static boolean checkProgram(String p, String pg) {
		boolean result = false;
		
		if(pg.equals(p) && (p.length() >= 1 && p.length() <= 10)) {
			result = true;
		}
		
		return result;
	}
	
	private static boolean checkFlagName(String fn) {
		boolean result = true;
		
		// 정의된 flag_name인지 검사합니다.
		if(!hm.containsKey(fn)) {
			result = false;
		}
		
		// flag_name의 길이를 검사합니다.
		if(!(fn.length() >= 2 && fn.length() <= 10)) {
			System.out.println(1);
			result = false;
		}
		
		// flag_name이 영어 대소문자로만 이루어져 있는지 검사합니다.
		for(int i = 1; i < fn.length(); i++) {
			char c = fn.charAt(i);
			
			if(!checkAlphabet(c)) {
				result = false;
			}
		}
		
		return result;
	}
	
	private static boolean checkAlphabet(char c) {
		int ctoi = c - '0';
		return (ctoi >= 17 && ctoi <= 42) || (ctoi >= 49 && ctoi <= 74);
	}
}

