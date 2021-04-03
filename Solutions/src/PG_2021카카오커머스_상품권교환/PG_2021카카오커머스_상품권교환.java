package PG_2021카카오커머스_상품권교환;

import java.io.*;
import java.util.*;

public class PG_2021카카오커머스_상품권교환 {
	
	static int[] gift_cards = {4, 5, 3, 2, 1};
	static int[] wants = {2, 4, 4, 5, 1};
	
	public static void main(String[] args) {
		int answer = 0;
		boolean[] v = new boolean[gift_cards.length];
		
		for(int i = 0, size = gift_cards.length; i < size; i++) {
			// 갖고 있는 카드가 원하는 카드라면 넘어감
			if(gift_cards[i] == wants[i]) {
				v[i] = true;
				continue;
			}
			
			// 원하는 카드를 받지 못한 사람만 진행
			for(int j = 0; j < size; j++) {
				if(!v[j] && i != j && wants[i] == gift_cards[j])  {
					int temp = gift_cards[i];
					gift_cards[i] = gift_cards[j];
					gift_cards[j] = temp;

					if(gift_cards[j] == wants[j]) {
						v[j] = true;
					}

					v[i] = true;
				}
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

