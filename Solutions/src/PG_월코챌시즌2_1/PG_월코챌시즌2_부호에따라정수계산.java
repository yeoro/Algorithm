package PG_����ç����2_1;

import java.io.*;
import java.util.*;

public class PG_����ç����2_��ȣ������������� {
	
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

