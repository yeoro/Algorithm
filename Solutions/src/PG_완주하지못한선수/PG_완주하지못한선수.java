package PG_완주하지못한선수;

import java.io.*;
import java.util.*;

public class PG_완주하지못한선수 {
	
	static String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
	static String[] completion = {"josipa", "filipa", "marina", "nikola"};
	static String answer;
	
	public static void main(String[] args) {
		
		HashMap<String, Integer> playerHm = new HashMap<String, Integer>();
		
		for(int i = 0; i < participant.length; i++) {
			String player = participant[i];
			
			if(!playerHm.containsKey(player)) {
				playerHm.put(player, 1);
			} else {
				playerHm.replace(player, playerHm.get(player)+1);
			}
		}
		
		for(int i = 0; i < completion.length; i++) {
			String player = completion[i];
			
			if(playerHm.containsKey(player)) {
				playerHm.replace(player, playerHm.get(player)-1);
			}
		}
		
		for(Map.Entry<String, Integer> elem : playerHm.entrySet()) {
			if(elem.getValue() > 0) {
				answer = elem.getKey();
				break;
			}
		}
		
		System.out.println(answer);
	}
}

