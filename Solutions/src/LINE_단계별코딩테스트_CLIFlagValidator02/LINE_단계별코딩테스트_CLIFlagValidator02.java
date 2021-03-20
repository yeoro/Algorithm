package LINE_단계별코딩테스트_CLIFlagValidator02;

import java.io.*;
import java.util.*;

public class LINE_단계별코딩테스트_CLIFlagValidator02 {
	
	static String program = "bank";
	static String[] flag_rules = {"-send STRING", "-a ALIAS -amount", "-amount NUMBERS"};
	static String[] commands = {"bank -send abc -amount 500 200 -a 400", "bank -send abc -a hey"};
	static HashMap<String, String> hm = new HashMap<String, String>();
	
	public static void main(String[] args) {
		// 결과 배열을 true 값으로 초기화 한 후, 유효성 검사 하나라도 통과하지 못하면 false 값으로 바꿔줍니다.
		boolean[] answer = new boolean[commands.length];
		Arrays.fill(answer, true);
		
		// 하나의 flag가 최대 하나의 ALIAS만 가지기 위해 ALIAS 상태를 관리할 ArrayList를 선언합니다.
		ArrayList<String> alias = new ArrayList<String>();
		
		// flag의 이름과 flag가 받아야 하는 인자의 종류 한 쌍으로 묶어 정의하기 위해 HashMap을 사용했습니다.
		StringTokenizer st;
		for(int i = 0; i < flag_rules.length; i++) {
			st = new StringTokenizer(flag_rules[i], " ");
			
			// ALIAS를 처리하기 위해 flag_name_2의 flag_argument_type을 flag_name_1에도 정의해줍니다.
			if(st.countTokens() == 3) {
				String flag_name_1 = st.nextToken();
				st.nextToken();
				String flag_name_2 = st.nextToken();
				
				// 이미 ALIAS를 갖고 있는 flag의 경우 ALIAS 처리를 건너뜁니다.
				if(alias.contains(flag_name_2)) {
					continue;
				}
				
				alias.add(flag_name_2);
				alias.add(flag_name_1);
				
				System.out.println(flag_name_1 + " " + hm.get(flag_name_2));
				hm.put(flag_name_1, hm.get(flag_name_2));
			} else {
				String flag_name = st.nextToken();
				String flag_argument_type = st.nextToken();
				
				hm.put(flag_name, flag_argument_type);
			}
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
			int nCnt = 0;
			int sCnt = 0;
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
						sCnt++;
						if(sCnt > 1 || !flag_argument.getClass().getSimpleName().equals("String")) {
							answer[i] = false;
						}
						break;
					case "STRINGS":
						if(!flag_argument.getClass().getSimpleName().equals("String")) {
							answer[i] = false;
						}
						break;
					case "NUMBER":
						nCnt++;
						if(nCnt > 1 || !checkNumber(flag_argument)) {
							answer[i] = false;
						}
						break;
					case "NUMBERS":
						if(!checkNumber(flag_argument)) {
							answer[i] = false;
						}
						break;
					case "NULL":
						// NULL type은 인자를 필요로하지 않으므로 다음 flag의 유효성 검사를 위해 flag 상태를 초기화해줍니다.
						flag_name = "";
						flag_argument_type = "";
						nCnt = 0;
						sCnt = 0;
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
	
	private static boolean checkNumber(String fa) {
		boolean result = true;
		
		try {
			Integer.parseInt(fa);
		} catch (Exception e) {
			result = false;
		}
		
		return result;
	}
}

