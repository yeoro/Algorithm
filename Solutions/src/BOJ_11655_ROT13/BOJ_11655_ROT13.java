package BOJ_11655_ROT13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11655_ROT13 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ", true);
		
		String[] arr = new String[st.countTokens()];
		
		int i = 0;
		while(st.hasMoreTokens()) {
			arr[i] = st.nextToken();
			i++;
		}
		
		for(int j = 0; j < arr.length; j++) {
			for(int k = 0; k < arr[j].length(); k++) {
				char c = arr[j].charAt(k);
				if(isUpper(c)) {
					c+=13;
					if(c > 90) {
						c-=26;
					}
				} else if(isLower(c)) {
					c+=13;
					if(c > 122) {
						c-=26;
					}
				}
				sb.append(c);
			}
		}
		
		System.out.println(sb);
		
		br.close();
		
	}
	
	static boolean isUpper(char c) {
		return c >= 65 && c <= 90; 
	}
	
	static boolean isLower(char c) {
		return c >= 97 && c <= 122;
	}
}
