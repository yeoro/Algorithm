package BOJ_10824_네수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10824_네수 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String[] arr = new String[st.countTokens()];
		
		int idx = 0;
		while(st.hasMoreTokens()) {
			arr[idx] = st.nextToken();
			idx++;
		}
		
		Long sum = Long.parseLong(arr[0]+arr[1]) + Long.parseLong(arr[2]+arr[3]);
		
		System.out.println(sum);
	}
	
}
