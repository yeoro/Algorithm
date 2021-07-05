package PG_����������;

import java.io.*;
import java.util.*;

class Solution {

	static ArrayList<String> temp = new ArrayList<String>();
	static ArrayList<String> list = new ArrayList<String>();
	static HashSet<String> ans = new HashSet<String>();
	static HashMap<String, Integer> hm = new HashMap<String, Integer>();
	static HashMap<String, Integer> cntHm = new HashMap<String, Integer>();
	static HashMap<String, Integer> idxCntHm = new HashMap<String, Integer>();
	static int N;

	public static void main(String[] args) {
		String[] logs = {"0001 3 95", "0001 5 90", "0001 5 100",
				"0002 3 95", "0001 7 80", "0001 8 80",
				"0001 10 90", "0002 10 90", "0002 7 80",
				"0002 8 80", "0002 5 100", "0003 99 90"};

		String[] answer;
		N = logs.length;

		for(int i = 0; i < N; i++) {
			// �α� ����� �����ȣ, ������ȣ, ������ ����
			String[] cur = logs[i].split(" ");

			String idx = cur[0]; // �����ȣ
			int no = Integer.parseInt(cur[1]); // ������ȣ
			int score = Integer.parseInt(cur[2]); // ����

			StringBuilder sb = new StringBuilder();
			sb.append(idx).append(" ").append(no);

			// ������ �� ������ ���� ���� ����
			hm.put(sb.toString(), score);

			// ������ �� Ǭ ������ ���� �ߺ� ����
			cntHm.put(sb.toString(), cntHm.getOrDefault(idx, 1));
		}

		// �������� ������ ����µ� ����� �ĺ����� ArrayList�� ����
		System.out.println("--------- hm");
		for(Map.Entry<String, Integer> e : hm.entrySet()) {
			String[] temp = e.getKey().split(" ");
			System.out.println("�����ȣ: " + temp[0] + " ������ȣ: " + temp[1] + " ����: " + e.getValue());
			
			list.add(e.getKey());
		}

		// ������ �� Ǭ ������ ���ؼ� �����ȣ�� �̾� �� �����ڰ� Ǭ ������ ����
		System.out.println("--------- cntHm");
		for(Map.Entry<String, Integer> e : cntHm.entrySet()) {
			String[] temp = e.getKey().split(" ");
			System.out.println("�����ȣ: " + temp[0] + " ������ȣ: " + temp[1] + " ������: " + e.getValue());
			
			String inputIdx = e.getKey().substring(0, 4);
			
			idxCntHm.put(inputIdx, idxCntHm.getOrDefault(inputIdx, 0)+1);
		}
		
		System.out.println("--------- idxCntHm");
		for(Map.Entry<String, Integer> e : idxCntHm.entrySet()) {
			System.out.println("�����ȣ: " + e.getKey() + " ������: " + e.getValue());
		}

		solve(0, 0);

		if(ans.size() > 0) { // ���������ڰ� ������ ���
			temp.clear();

			for(String s : ans) {
				temp.add(s);
			}

			answer = new String[temp.size()];
			for(int i = 0; i < temp.size(); i++) {
				answer[i] = temp.get(i);
			}

			Arrays.sort(answer);
		} else { // ���������ڰ� �������� ���� ���
			answer = new String[1];
			answer[0] = "None";
		}

		System.out.println(Arrays.toString(answer));
	}

	// ������ �� �����ڰ� Ǭ ���� ����
	private static void solve(int depth, int idx) {
		if(depth == 2) {
			isCheat();
			return;
		}

		for(int i = idx; i < list.size(); i++) {
			if(!temp.contains(list.get(i))) {
				temp.add(list.get(i));
				solve(depth+1, i+1);
				temp.remove(temp.size()-1);
			}
		}
	}

	private static void isCheat() {
		String[] s1 = temp.get(0).split(" ");
		String[] s2 = temp.get(1).split(" ");

		int proCnt1 = idxCntHm.get(s1[0]);
		int proCnt2 = idxCntHm.get(s2[0]);

		int no1 = Integer.parseInt(s1[1]);
		int no2 = Integer.parseInt(s2[1]);

		int score1 = hm.get(temp.get(0));
		int score2 = hm.get(temp.get(1));

		if(proCnt1 >= 5 && proCnt2 >= 5) { // �� �����ڰ� Ǭ �������� 5���� Ŀ����
			if(proCnt1 == proCnt2) { // �� �����ڰ� Ǭ �������� ���ƾ���
				if(score1 == score2) { // �� �����ڰ� Ǭ ������ ������ ���ƾ���
					if(no1 == no2) { // �� �����ڰ� Ǭ ������ ��ȣ�� ���ƾ���
						ans.add(s1[0]);
						ans.add(s2[0]);
					}
				}
			}
		}
	}
}

