package PG_월코챌시즌2_1;

import java.io.*;
import java.util.*;

public class PG_월코챌시즌2_부호에따라정수계산 {
	
	public static void main(String[] args) {
		
		int[] absolutes = {4, 7, 12};
		boolean[] signs = {true, false, true};
		
		int answer = 0;
		for(int i = 0, size = absolutes.length; i < size; i++) {
			if(signs[i]) {
				answer += absolutes[i];
			} else {
				answer -= absolutes[i];
			}
		}
		
		System.out.println(answer);
		
	}
}

