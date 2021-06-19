package Codility_02_파일찾기;

import java.io.*;
import java.sql.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
	
	static ArrayList<String> backUps = new ArrayList<String>();
	static ArrayList<String> passDate = new ArrayList<String>();
	static ArrayList<String> passSize = new ArrayList<String>();
	static double K = Math.pow(2, 10);
	static double M = Math.pow(2, 20);
	static double G = Math.pow(2, 30);
	static double standardSize = 14 * M;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws ParseException {
		String S = " 715K 2009-09-23 system.zip~\\n "
				+ "179K 2013-08-14 to-do-list.xml~\\n "
				+ "645K 2013-06-19 blockbuster.mpeg~\\n  "
				+ "536 2010-12-12 notes.html\\n "
				+ "688M 1990-02-11 delete-this.zip~\\n  "
				+ "23K 1987-05-24 setup.png~\\n "
				+ "616M 1965-06-06 important.html\\n  "
				+ "14M 1992-05-31 crucial-module.java~\\n "
				+ "192K 1990-01-31 very-long-filename.dll~";
		
		String answer = "";
		String[] files = S.split("\\\\n");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date day1 = df.parse("1990-01-31");
		
		// 백업파일 추려내기
		for(String file : files) {
			String[] cut = file.split(" ");

			if(cut[3].charAt(cut[3].length()-1) == '~') {
				backUps.add(file);
			}
		}
		
		// 날짜 추려내기
		for(String file : backUps) {
			String[] cut = file.split(" ");

			Date day2 = df.parse(cut[2]);
			
			if(day1.compareTo(day2) < 0) {
				passDate.add(file);
			}
		}
		
		// 크기 추려내기
		for(String file : passDate) {
			String[] cut = file.split(" ");

			cal(cut[1]);

			passSize.add(file);
		}
		
		// 파일명 길이
		loop: for(String file : passSize) {
			String[] cut = file.split(" ");

			int idx = 0;
			StringBuilder fileName = new StringBuilder(cut[3]);

			for(int i = fileName.length()-1; i >= 0; i--) {
				if(fileName.charAt(i) == '.') {
					idx = i;
					min = Math.min(idx, min);
					continue loop;
				}
			}
		}
		
		if(min == Integer.MAX_VALUE) {
			answer = "NO FILES";
		} else {
			answer = Integer.toString(min);
		}
		
		System.out.println(answer);
	}
	
	private static boolean cal(String size) {
		char unit = size.charAt(size.length()-1); 
		int num = Integer.parseInt(size.substring(0, size.length()-1));
		double fileSize = 0;
		
		switch(unit) {
		case 'K':
			fileSize = num * K;
			break;
		case 'M':
			fileSize = num * M;
			break;
		case 'G':
			fileSize = num * G;
			break;
		default :
			break;
		}
		
		if(standardSize > fileSize) {
			return true;
		}
		
		return false;
	}
}