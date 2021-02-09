package BOJ_11723_����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11723_���� {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int S = 0;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			int x = 0;
			
			switch(order) {
			case "add": 
				// S�� x�� �߰��Ѵ�. (1 �� x �� 20) S�� x�� �̹� �ִ� ��쿡�� ������ �����Ѵ�.
				x = oneToZero(Integer.parseInt(st.nextToken()));
				if((S & 1<<x) != 1) {
					S |= 1<<x;
				}
				break;
			case "remove":
				// S���� x�� �����Ѵ�. (1 �� x �� 20) S�� x�� ���� ��쿡�� ������ �����Ѵ�.
				x = oneToZero(Integer.parseInt(st.nextToken()));
				if((S & 1<<x) != 0) {
					S ^= 1<<x;
				}
				break;
			case "check":
				// S�� x�� ������ 1��, ������ 0�� ����Ѵ�. (1 �� x �� 20)
				x = oneToZero(Integer.parseInt(st.nextToken()));
				if((S & 1<<x) != 0) {
					bw.write(1 + "\n");
				} else {
					bw.write(0 + "\n");
				}
				break;
			case "toggle":
				// S�� x�� ������ x�� �����ϰ�, ������ x�� �߰��Ѵ�. (1 �� x �� 20)
				x = oneToZero(Integer.parseInt(st.nextToken()));
				if((S & 1<<x) != 0) {
					S ^= 1<<x;
					break;
				} else {
					S |= 1<<x;
					break;
				}
			case "all":
				// S�� {1, 2, ..., 20} ���� �ٲ۴�.
				S = 0;
				for(int idx = 0; idx <= 20; idx++) {
					S |= 1<<idx;
				}
				break;
			case "empty":
				// S�� ���������� �ٲ۴�. 
				S = 0;
				break;
			}
		}
		
		br.close();
		bw.flush();
	}
	
	private static int oneToZero(int one) {
		if(one == 1) {
			one = 0;
		}
		return one;
	}
}

