package BOJ_01181_단어정렬;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			
			hm.put(input, input.length());
		}
		
		ArrayList<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(hm.entrySet());
		
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if(o1.getValue() == o2.getValue()) {
					return o1.getKey().compareTo(o2.getKey());
				}
				
				return Integer.compare(o1.getValue(), o2.getValue());
			}
		});
		
		for(Entry<String, Integer> e : list) {
			bw.write(e.getKey() + "\n");
		}
		
		br.close();
		bw.flush();
	}
}

