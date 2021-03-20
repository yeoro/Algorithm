package LINE_�ܰ躰�ڵ��׽�Ʈ_CLIFlagValidator01;

import java.io.*;
import java.util.*;

public class LINE_�ܰ躰�ڵ��׽�Ʈ_CLIFlagValidator01 {
	
	static String program = "line";
	static String[] flag_rules = {"-s STRING", 
								  "-n NUMBER", 
								  "-e NULL"};
	static String[] commands = {"line -n 100 -s hi -e", 
								"lien -s Bye"};
	static HashMap<String, String> hm = new HashMap<String, String>();
	
	public static void main(String[] args) {
		// ��� �迭�� true ������ �ʱ�ȭ �� ��, ��ȿ�� �˻� �ϳ��� ������� ���ϸ� false ������ �ٲ��ݴϴ�.
		boolean[] answer = new boolean[commands.length];
		Arrays.fill(answer, true);
		
		// flag�� �̸��� flag�� �޾ƾ� �ϴ� ������ ���� �� ������ ���� �����ϱ� ���� HashMap�� ����߽��ϴ�.
		StringTokenizer st;
		for(int i = 0; i < flag_rules.length; i++) {
			st = new StringTokenizer(flag_rules[i], " ");
			hm.put(st.nextToken(), st.nextToken());
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
						// NULL type�� ���ڸ� �ʿ������ �����Ƿ� ���� flag�� ��ȿ�� �˻縦 ���� flag ���¸� �ʱ�ȭ���ݴϴ�.
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
}

