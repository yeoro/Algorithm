package PG_단어변환;

import java.io.*;
import java.util.*;

class Solution {

	static class Word {
		String w;
		int cnt;

		public Word(String w, int cnt) {
			this.w = w;
			this.cnt = cnt;
		}
	}
	static HashMap<String, Integer> hm = new HashMap<String, Integer>();
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		for(int i = 0; i < words.length; i++) {
			hm.put(words[i], 0);
		}

		solve(begin, target);

		if(min == Integer.MAX_VALUE) {
			System.out.println(0);
		} 
		
		System.out.println(min);
	}

	private static void solve(String begin, String target) {
		Queue<Word> q = new LinkedList<Word>();
		q.offer(new Word(begin, 0));

		while(!q.isEmpty()) {
			Word cur = q.poll();
			String s = cur.w;
			int cnt = cur.cnt;

			if(s.equals(target)) {
				min = Math.min(min, cnt);
			}

			for(int i = 0; i < s.length(); i++) {
				for(int j = 97; j <= 122; j++ ) {
					char change = (char) j;

					if(s.charAt(i) != change) {
						StringBuilder sb = new StringBuilder(s);
						sb.setCharAt(i, change);
						String nextWord = sb.toString();

						if(hm.containsKey(nextWord)) {
							int nextCnt = hm.get(nextWord);

							if(nextCnt == 0 || nextCnt > cnt+1) {
								hm.put(nextWord, cnt+1);
								q.offer(new Word(sb.toString(), cnt+1));
							}
						}
					}
				}
			}
		}
	}
}
