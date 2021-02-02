package BOJ_13414_수강신청;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class BOJ_13414_수강신청 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> hm = new LinkedHashMap<String, String>();
		
		for(int i = 0; i < L; i++) {
			String s = br.readLine();
			
			if(hm.containsKey(s)) {
				hm.remove(s);
			}
			
			hm.put(s, s);
		}
		
		Iterator<String> it = hm.keySet().iterator();
		int idx = 0;
		while(it.hasNext() && idx < K) {
			String key = it.next();
			String student = hm.get(key);
			bw.write(student + "\n");
			
			idx++;
		}
		
		br.close();
		bw.flush();
	}
		
}

