package BOJ_01748_수이어쓰기1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_01748_수이어쓰기1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int res = 0;
		for(int i = 1; i <= N; i++) {
			int cnt = 0;
			int num = i;
			
			while(num > 0) {
				num /= 10;
				++cnt;
			}
			
			res += cnt;
			
		}
		
		bw.write(res + "\n");
		
		br.close();
		bw.flush();
	}
}

