package BOJ_01062_°¡¸£Ä§;

import java.io.*;
import java.util.*;

class Main {
	
	static char[] alphabet = {'b', 'd', 'e', 'f', 'g', 'h', 'j', 
							  'k', 'l', 'm', 'o', 'p', 'q', 'r', 
							  's', 'u', 'v', 'w', 'x', 'y', 'z'};
	static ArrayList<Character> base = new ArrayList<Character>();
	static ArrayList<String> words = new ArrayList<String>();
	static boolean[] v;
	static int N, K, l = alphabet.length, max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		v = new boolean[l];
		
		for(int i = 0; i < N; i++) {
			words.add(br.readLine().replace("anta", "").replace("tica", ""));
		}
		
		base.add('a');
		base.add('c');
		base.add('i');
		base.add('n');
		base.add('t');
		
		solve(0, 0);
		
		if(max == Integer.MIN_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(max);
		}
		
		br.close();
	}
	
	private static void solve(int depth, int idx) {
		if(depth == K-5) {
			int cnt = 0;
			
			loop: for(String w : words) {
				for(int i = 0; i < w.length(); i++) {
					if(!base.contains(w.charAt(i))) {
						continue loop;
					}
				}
				
				cnt++;
			}
			
			max = Math.max(cnt, max);
			
			return;
		}
		
		for(int i = idx; i < l; i++) {
			if(!v[i]) {
				v[i] = true;
				base.add(alphabet[i]);
				solve(depth+1, i+1);
				v[i] = false;
				base.remove(base.size()-1);
			}
		}
	}
}