package BOJ_20327_배열돌리기6;

import java.io.*;
import java.util.*;

class Main {
	
	static int[][] arr, copy;
	static int N = 1, R, nTemp, k, l;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		nTemp = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < nTemp; i++) {
			N *= 2;
		}
		
		arr = new int[N][N];
		copy = new int[N][N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			k = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			System.out.println(R + "번째 연산 -------- " + k + " " + l);
			solve();
			
			for(int k = 0; k < N; k++) {
				for(int l = 0; l < N; l++) {
					System.out.print(copy[k][l] + " ");
				}
				System.out.println();
			}
			
		}
		
		
		br.close();
	}
	
	private static void solve() {
		int row = 1; int col = 1;
		for(int i = 0; i < l; i++) {
			row *= 2;
			col *= 2;
		}
		
		// 부분 배열의 시작점
		for(int i = 0; i < N; i+=row) {
			for(int j = 0; j < N; j+=col) {
				System.out.println("-----------------init " + i + " " + j);
				cal(i, j, row-1);
				for(int k = 0; k < N; k++) {
					for(int l = 0; l < N; l++) {
						System.out.print(copy[k][l] + " ");
					}
					System.out.println();
				}
			}
		}
	}
	
	private static void cal(int x, int y, int e) {
		int mid = e / 2;

		switch(k) {
		case 1:
			int idx = 0;
			for(int i = x; i <= x+mid; i++) {
				for(int j = y; j <= y+e; j++) {
					int temp = arr[i][j];
					arr[i][j] = arr[x+e-idx][j];
					arr[x+e-idx][j] = temp;
				}
				idx++;
			}
			break;
		case 2:
			idx = 0;
			for(int i = y; i <= y+mid; i++) {
				for(int j = x; j <= x+e; j++) {
					int temp = arr[j][i];
					arr[j][i] = arr[j][y+e-idx];
					arr[j][y+e-idx] = temp;
				}
				idx++;
			}
			break;
		case 3:
			copyArr();
			
			for(int i = 0; i <= mid; i++) {
				
				System.out.println("------- " + i);
				System.out.println("위");
				for(int j = y+i; j < y+e-i; j++) {
					copy[x+j-y][y+e-i] = arr[x+i][j];
					
					System.out.println((x+i) + " " + (j) + " -> " +  (x+j-y) + " " + (y+e-i));
				}
				
				System.out.println("우");
				for(int j = x+i; j < x+e-i; j++) {
					copy[x+e-i][y+e-j+x] = arr[j][y+e-i];
					
					System.out.println((j) + " " + (y+e-i) + " -> " + (x+e-i) + " " + (y+e-j+x));
				}
			}
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		}
	}
	
	private static void copyArr() {
		for(int i = 0; i < N; i++) {
			System.arraycopy(arr[i], 0, copy[i], 0, arr[i].length);
		}
	}
}

