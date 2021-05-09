package PG_2021½æ¸ÓÄÚµù_¸®ÇÁÆ®Å¾½Â;

import java.io.*;
import java.util.*;

class Solution {
	
	static class Person implements Comparable<Person> {
		int id, time, tier;

		public Person(int id, int time, int tier) {
			this.id = id;
			this.time = time;
			this.tier = tier;
		}

		@Override
		public int compareTo(Person o) {
			if(Integer.compare(this.tier, o.tier) == 0) {
				if(Integer.compare(this.time, o.time) == 0) {
					return Integer.compare(this.id, o.id);
				}
				return Integer.compare(this.time, o.time);
			}
			return Integer.compare(this.tier, o.tier);
		}

		@Override
		public String toString() {
			return "Person [id=" + id + ", time=" + time + ", tier=" + tier + "]";
		}
	}
	
	public static void main(String[] args) {
		int[] t = {0,1,3,0};
		int[] r = {0,1,2,3};
		
		ArrayList<Person>[] list = new ArrayList[10002];
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		for(int i = 0; i < 10002; i++) {
			list[i] = new ArrayList<Person>();
		}
		
		for(int i = 0; i < t.length; i++) {
			list[t[i]].add(new Person(i, t[i], r[i]));
		}
		
		for(int i = 0; i < 10001; i++) {
			if(list[i].size() > 0) {
				Collections.sort(list[i]);
				
				int id = list[i].get(0).id;
				res.add(id);
				
				list[i].remove(0);
				
				for(Person p : list[i]) {
					list[i+1].add(new Person(p.id, p.time, p.tier));
				}
			}
		}
		
		int[] answer = new int[res.size()];
		
		for(int i = 0; i < res.size(); i++) {
			answer[i] = res.get(i);
		}
		
		System.out.println(Arrays.toString(answer));
	}
}

