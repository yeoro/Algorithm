package PG_º£½ºÆ®¾Ù¹ü;

import java.util.*;

class Solution {

	static class Song implements Comparable<Song>{
		int idx, play;

		public Song(int idx, int play) {
			this.idx = idx;
			this.play = play;
		}

		@Override
		public int compareTo(Song o) {
			if(this.play == o.play) {
				return Integer.compare(this.idx, o.idx);
			}
			return Integer.compare(o.play, this.play);
		}
	}

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		HashMap<String, Integer> gHm = new HashMap<String, Integer>();
		LinkedHashMap<String, List<Song>> sHm = new LinkedHashMap<String, List<Song>>();
		ArrayList<Integer> list = new ArrayList<Integer>();

		for(int i = 0; i < genres.length; i++) {
			gHm.put(genres[i], gHm.getOrDefault(genres[i], 0)+plays[i]);
		}

		List<Map.Entry<String, Integer>> sortList = new ArrayList<Map.Entry<String, Integer>>(gHm.entrySet());

		Collections.sort(sortList, (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

		for(Map.Entry<String, Integer> e : sortList) {
			sHm.put(e.getKey(), new ArrayList<Song>());
		}

		for(int i = 0; i < plays.length; i++) {
			sHm.get(genres[i]).add(new Song(i, plays[i]));
		}

		for(Map.Entry<String, List<Song>> e : sHm.entrySet()) {
			Collections.sort(e.getValue());

			if(e.getValue().size() >= 2) {
				list.add(e.getValue().get(0).idx);
				list.add(e.getValue().get(1).idx);
			} else {
				list.add(e.getValue().get(0).idx);
			}
		}

		int[] answer = new int[list.size()];

		for(int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		System.out.println(Arrays.toString(answer));
	}
}