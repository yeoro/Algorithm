package PG_2021�����Ī_�ζ�;

import java.io.*;
import java.util.*;

public class PG_2021�����Ī_�ζ� {
	
	public static void main(String[] args) {
		int[] lottos = {1, 2, 3, 4, 5, 6};
		int[] win_nums = {7, 8, 9, 10, 11, 12};
		
		int[] answer = new int[2];
		
		int zero = 0;
		int cur = 0;
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		for(int i = 0, size = win_nums.length; i < size; i++) {
			hm.put(win_nums[i], 0);
		}
		
		// ������ �ζ� ��ȣ �� ��÷ ��ȣ ����
		for(int i = 0, size = lottos.length; i < size; i++) {
			int num = lottos[i];
			
			if(num == 0) {
				zero++;
				continue;
			}
			
			if(hm.containsKey(num)) {
				cur++;
			}
		}
		
		// �ְ� ���� : ���� �𸣴� ��ȣ ��� �´� ���
		int max = 7 - (zero + cur);
		
		// ���� ���� : ���� �𸣴� ��ȣ ��� Ʋ���� ���
		int min = 7 - cur;
		
		if(min == 7) {
			min--;
		}
		
		answer[0] = max;
		answer[1] = min;
		
		System.out.println(Arrays.toString(answer));
	}
}

