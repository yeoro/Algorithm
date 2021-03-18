package BOJ_17281_야구;

import java.io.*;
import java.util.*;

public class BOJ_17281_야구 {
	 
	static int[][] inning;
	static int[] lineup, base;
	static boolean[] v;
	static int N, max = Integer.MIN_VALUE, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		inning = new int[N][9+1];
		lineup = new int[10];
		v = new boolean[10];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= 9; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		lineup[4] = 1;
		v[4] = true;
		
		makeLineup(2);
		
		bw.write(max + "\n");
		
		bw.flush();
		br.close();
	}
	
	private static void makeLineup(int depth) {
		if(depth == 10) {
			int sum = attack();
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 1; i <= 9; i++) {
			if(!v[i]) {
				v[i] = true;
				lineup[i] = depth;
				makeLineup(depth+1);
				v[i] = false;
			}
		}
	}
	
	private static int attack() {
		int sum = 0;
		int startPlayer = 1;

		loop: for(int i = 0; i < N; i++) {
			int out = 0;
			base = new int[3];
			
			for(int j = startPlayer; j <= 9; j++) {
				int curPlayer = lineup[j];
				int score = inning[i][curPlayer];
				
				switch(score) {
				case 0: // �븘�썐
					out++;
					break;
				case 1: // �븞��
					for(int k = 2; k >= 0; k--) {
						if(base[k] == 1) {
							if(k == 2) {
								sum++;
							} else {
								base[k+1] = base[k];
							}
							base[k] = 0;
						}
					}
					base[0] = 1;
					break;
				case 2: // 2猷⑦�
					for(int k = 2; k >= 0; k--) {
						if(base[k] == 1) {
							if(k > 0) {
								sum++;
							} else {
								base[k+2] = base[k];
							}
							base[k] = 0;
						}
					}
					base[1] = 1;
					break;
				case 3: // 3猷⑦�
					for(int k = 2; k >= 0; k--) {
						if(base[k] == 1) {
							sum++;
							base[k] = 0;
						}
					}
					base[2] = 1;
					break;
				case 4: // 4猷⑦�
					for(int k = 2; k >= 0; k--) {
						if(base[k] == 1) {
							sum++;
							base[k] = 0;
						}
					}
					sum++;
					break;
				}
				
				// 3�븘�썐�씠 �븘�땶�뜲 留� 留덉�留� ���옄源뚯� 移� 寃쎌슦 留� �븵���옄濡� �닚�꽌 蹂�寃�
				if(out != 3 && j == 9) {
					j = 0;
				}
				
				// 3�븘�썐�씤 寃쎌슦 �떎�쓬 �씠�떇�쓽 泥ル쾲吏� ���옄 �꽕�젙
				if(out == 3) {
					if(j == 9) {
						j = 0;
					}
					startPlayer = j+1;
					continue loop;
				}
			}
		}
		
		return sum;
	}
}

