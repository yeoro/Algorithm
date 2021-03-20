package LINE_�ܰ躰�ڵ��׽�Ʈ_CLIFlagValidator02;

import java.io.*;
import java.util.*;

public class LINE_�ܰ躰�ڵ��׽�Ʈ_CLIFlagValidator02 {
	
	static String program = "bank";
	static String[] flag_rules = {"-send STRING", "-a ALIAS -amount", "-amount NUMBERS"};
	static String[] commands = {"bank -send abc -amount 500 200 -a 400", "bank -send abc -a hey"};
	static HashMap<String, String> hm = new HashMap<String, String>();
	
	public static void main(String[] args) {
		// ��� �迭�� true ������ �ʱ�ȭ �� ��, ��ȿ�� �˻� �ϳ��� ������� ���ϸ� false ������ �ٲ��ݴϴ�.
		boolean[] answer = new boolean[commands.length];
		Arrays.fill(answer, true);
		
		// �ϳ��� flag�� �ִ� �ϳ��� ALIAS�� ������ ���� ALIAS ���¸� ������ ArrayList�� �����մϴ�.
		ArrayList<String> alias = new ArrayList<String>();
		
		// flag�� �̸��� flag�� �޾ƾ� �ϴ� ������ ���� �� ������ ���� �����ϱ� ���� HashMap�� ����߽��ϴ�.
		StringTokenizer st;
		for(int i = 0; i < flag_rules.length; i++) {
			st = new StringTokenizer(flag_rules[i], " ");
			
			// ALIAS�� ó���ϱ� ���� flag_name_2�� flag_argument_type�� flag_name_1���� �������ݴϴ�.
			if(st.countTokens() == 3) {
				String flag_name_1 = st.nextToken();
				st.nextToken();
				String flag_name_2 = st.nextToken();
				
				// �̹� ALIAS�� ���� �ִ� flag�� ��� ALIAS ó���� �ǳʶݴϴ�.
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
			// �Էµ� ��ɾ ������ �������� ������ �迭�� ����ϴ�.
			String[] cmd = commands[i].split(" ");
			
			// ��ɾ��� �� �տ� �ִ� program �̸��� ��ȿ���� �˻��մϴ�.
			String pg = program;
			if(!checkProgram(cmd[0], pg)) {
				answer[i] = false;
			}
			
			// ��ɾ ������ '-'�� �����ϸ� flag_name, �׷��� ������ flag_argument�� �Ǵ��մϴ�.
			String flag_name = "";
			String flag_argument_type = "";
			int nCnt = 0;
			int sCnt = 0;
			for(int j = 1; j < cmd.length; j++) {
				if(cmd[j].charAt(0) == '-') { // flag_name
					// flag_name�� ��ȿ�ϴٸ� ������ ���� flag_argument�� �˻��ϱ� ���� flag_rules�� �����մϴ�.
					if(checkFlagName(cmd[j])) { 
						flag_name = cmd[j];
						flag_argument_type = hm.get(cmd[j]);
					} else {
						answer[i] = false;
						break;
					}
				} else { // flag_argument
					// �����ϴ� flag�� ���� flag_argument�� ������ �˻��մϴ�.
					if(flag_name.equals("")) {
						answer[i] = false;
						break;
					}
					
					String flag_argument = cmd[j];
					// �����ϴ� flag�� �䱸�ϴ� flag_argument_type���� �˻��մϴ�.
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
						// NULL type�� ���ڸ� �ʿ������ �����Ƿ� ���� flag�� ��ȿ�� �˻縦 ���� flag ���¸� �ʱ�ȭ���ݴϴ�.
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
		
		// ���ǵ� flag_name���� �˻��մϴ�.
		if(!hm.containsKey(fn)) {
			result = false;
		}
		
		// flag_name�� ���̸� �˻��մϴ�.
		if(!(fn.length() >= 2 && fn.length() <= 10)) {
			System.out.println(1);
			result = false;
		}
		
		// flag_name�� ���� ��ҹ��ڷθ� �̷���� �ִ��� �˻��մϴ�.
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

