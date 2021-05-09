package PG_2021썸머코딩_주가데이터추출;

import java.io.*;
import java.util.*;

class Solution {
	
	static class Data implements Comparable<Data> {
		int price, date;

		public Data(int price, int date) {
			this.price = price;
			this.date = date;
		}

		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.date, o.date);
		}
	}
	
	public static void main(String[] args) {
		String code = "012345";
		String day = "20190620";
		String[] data = {"price=80 code=987654 time=2019062113",
					 	 "price=90 code=012345 time=2019062014",
					 	 "price=120 code=987654 time=2019062010",
					 	 "price=110 code=012345 time=2019062009",
					 	 "price=95 code=012345 time=2019062111"};
		int[] answer = {};
		
		PriorityQueue<Data> pq = new PriorityQueue<Data>();
		
		for(int i = 0; i < data.length; i++) {
			String[] temp = data[i].split(" ");
			
			String price = temp[0].substring(6);
			String curCode = temp[1].substring(5, 11);
			String date = temp[2].substring(5, 15);
			
			if(code.equals(curCode) && day.equals(date.substring(0, 8))) {
				pq.offer(new Data(Integer.parseInt(price), Integer.parseInt(date)));
			}
		}
		
		answer = new int[pq.size()];
		
		int idx = 0;
		while(!pq.isEmpty()) {
			answer[idx] = pq.poll().price;
			idx++;
		}
		
		System.out.println(Arrays.toString(answer));
	}
}

