package PG_¿ù°£ÄÚµåÃ§¸°Áö½ÃÁð2_110»ðÀÔ;

import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		String[] s = {"1110","100111100","0111111010", "1100111010"};
		String[] answer = new String[s.length];
		
		for(int i = 0; i < s.length; i++) {
//			System.out.println("--------------" + i);
			String cur = s[i];
			long min = Long.parseLong(cur, 2);
			StringBuilder sb;
			
			while(true) {
				sb = new StringBuilder(cur);
				if(cur.contains("110")) {
					int idx1 = cur.lastIndexOf("110");
					
					if(cur.contains("111")) {
						int idx2 = cur.indexOf("111");
						
						if(Math.abs(idx1 - idx2) >= 3 && idx1 > idx2) {
							sb.replace(idx2, idx2+3, "110");
							sb.replace(idx1, idx1+3, "111");
							
//							System.out.println("-----111ÀÌ¶û ¹Ù²Þ");
//							System.out.println(cur);
//							System.out.println(sb.toString());
//							System.out.println("-----");
						} else {
							
							int zero = cur.indexOf("0", idx1+3);
							
							if(zero != -1) {
								sb.insert(zero+1, "110");
								sb.replace(idx1, idx1+3, "");
							
//								System.out.println("-----0ÀÌ¶û ¹Ù²Þ");
//								System.out.println(cur);
//								System.out.println(sb.toString());
//								System.out.println("-----");
							} else {
								int one = cur.lastIndexOf("1", idx1-1);
								
								if(one != -1) {
									sb.replace(idx1, idx1+3, "");
									sb.insert(one, "110");
									
//									System.out.println("-----1ÀÌ¶û ¹Ù²Þ");
//									System.out.println(cur);
//									System.out.println(sb.toString());
//									System.out.println("-----");
								}
							}
						} 
					} 
				}
				
				long temp = Long.parseLong(sb.toString(), 2);
				
				if(temp < min) {
					min = temp;
					cur = sb.toString();
				} else {
					break;
				}
			}
			
			answer[i] = cur;
		}
		
		System.out.println(Arrays.toString(answer));
	}
}

