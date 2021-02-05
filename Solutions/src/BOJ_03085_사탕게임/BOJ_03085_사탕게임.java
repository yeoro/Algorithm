package BOJ_03085_��������;

import java.util.Scanner;

public class BOJ_03085_�������� {
	
	static char[][] candy, copy;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		candy = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String input = sc.next();
			for(int j = 0; j < N; j++) {
				candy[i][j] = input.charAt(j);
			}
		}
		
		result = Math.max(cntRow(candy), cntColumn(candy));
		
		solve();

		System.out.println(result);
		
		sc.close();
	}
	
	private static void solve() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
				for(int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if(isIn(nx, ny)) {
						// �ٲٰ� ����� �ӽ� �迭 ����
						copy = new char[candy.length][candy[0].length];
						for(int l = 0; l < copy.length; l++) {
							System.arraycopy(candy[l], 0, copy[l], 0, candy[0].length);
						}

						// ������ �� ĭ�� �ٸ� �����̸� ��ȯ
						if(copy[i][j] != copy[nx][ny]) {
							char temp = copy[i][j];
							copy[i][j] = copy[nx][ny];
							copy[nx][ny] = temp;
						}
						
						// ��ȯ �� ���� �Ա�
						result = Math.max(result, Math.max(cntRow(copy), cntColumn(copy)));
					}
				}
			}
		}
	}
	
	// �� ���
	private static int cntRow(char[][] candyCopy) {
		int max = 0;
		for(int i = 0; i < N; i++) {
			int cnt = 1; 
			for(int j = 0; j < N-1; j++) {
				if(candyCopy[i][j] == candyCopy[i][j+1]) {
					cnt++;
				} else {
					cnt = 1;
				}
				if(max < cnt) {
					max = cnt;
				}
			}
		}
		return max;
	}
	
	// �� ���
	private static int cntColumn(char[][] candyCopy) {
		int max = 0;
		for(int i = 0; i < N; i++) {
			int cnt = 1;
			for(int j = 0; j < N-1; j++) {
				if(candyCopy[j][i] == candyCopy[j+1][i]) {
					cnt++;
				} else {
					cnt = 1;
				}
				if(max < cnt) {
					max = cnt;
				}
			}
		}
		return max;
	}
	
	private static boolean isIn(int x, int y) {
		return x < N && x >= 0 && y < N && y >= 0;
	}
}

