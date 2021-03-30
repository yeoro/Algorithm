package PG_전화번호목록;

import java.io.*;
import java.util.*;

public class PG_전화번호목록 {
	
	static String[] phone_book = {"119", "97674223", "1195524421"};
	
	public static void main(String[] args) {
		boolean answer = true;

		Arrays.sort(phone_book);
		
		for(int i = 0, size = phone_book.length-1; i < size; i++) {
			String str1 = phone_book[i];
			String str2 = phone_book[i+1];
			
			if(str2.startsWith(str1)) {
				answer = false;
				break;
			}
		}

		System.out.println(answer);
	}
}

