package PG_2021īī��Ŀ�ӽ�_��ǰ�Ǳ�ȯ;

import java.io.*;
import java.util.*;

public class PG_2021īī��Ŀ�ӽ�_��ǰ�Ǳ�ȯ {
	
	static int[] gift_cards = {5, 5, 5, 5, 5};
	static int[] wants = {4, 4, 4, 4, 4};
	
	
	public static void main(String[] args) {
		int answer = 0;
		boolean[] v = new boolean[gift_cards.length];
		
		for(int i = 0, size = gift_cards.length; i < size; i++) {
			int curCard = gift_cards[i];
			int wantCard = wants[i];
			
			// ���ϴ� ī�尡 �ƴ� ��� ��ȯ
			if(curCard != wantCard) {
				for(int j = 0; j < size; j++) {
					if(!v[j] && i != j && wantCard == gift_cards[j])  {
						int temp = gift_cards[i];
						gift_cards[i] = gift_cards[j];
						gift_cards[j] = temp;
						
						v[i] = true;
					}
				}
			} else if(curCard == wantCard) {
				v[i] = true;
				continue;
			}
		}
		
		for(int i = 0, size = v.length; i < size; i++) {
			if(!v[i]) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}

