package BOJ_17406_배열돌리기4;

import java.io.*;
import java.util.*;

public class BOJ_17406_배열돌리기4 {
	
	static ArrayList<Integer>[] list;
	static ArrayList<Integer> temp = new ArrayList<Integer>();
	static int[][] arr, copyArr, rotateArr;
	static boolean[] v;
	static int N, M, K, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1];
		copyArr = new int[N+1][M+1];
		rotateArr = new int[N+1][M+1];
		v = new boolean[K];
		list = new ArrayList[K];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < K; i++) {
			list[i] = new ArrayList<Integer>();
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < 3; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		solve(0);
		
		System.out.println(min);
		
		br.close();
	}
	
	private static void solve(int cnt) {
		if(cnt == K) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					copyArr[i][j] = arr[i][j];
					rotateArr[i][j] = arr[i][j];
				}
			}
			
			rotate();
			
			int curMin = Integer.MAX_VALUE;
			
			for(int i = 1; i <= N; i++) {
				int sum = 0;
				for(int j = 1; j <= M; j++) {
					sum += copyArr[i][j];
				}
				curMin = Math.min(curMin, sum);
			}
			
			min = Math.min(curMin, min);
			
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if(!temp.contains(i)) {
				temp.add(i);
				solve(cnt+1);
				temp.remove(temp.size()-1);
			}
		}
	}
	
	private static void rotate() {
		for(int i = 0; i < temp.size(); i++) {
			int r = list[temp.get(i)].get(0);
			int c = list[temp.get(i)].get(1);
			int s = list[temp.get(i)].get(2);
			
			for(int l = s; l > 0; l--) {
				for(int j = c-l; j < c+l; j++) {
					rotateArr[r-l][j+1] = copyArr[r-l][j];
				}
				
				for(int j = r-l; j < r+l; j++) {
					rotateArr[j+1][c+l] = copyArr[j][c+l];
				}
				
				for(int j = c+l; j > c-l; j--) {
					rotateArr[r+l][j-1] = copyArr[r+l][j];
				}
				
				for(int j = r+l; j > r-l; j--) {
					rotateArr[j-1][c-l] = copyArr[j][c-l];
				}
			}
			
			for(int j = 1; j <= N; j++) {
				for(int k = 1; k <= M; k++) {
					copyArr[j][k] = rotateArr[j][k];
				}
			}
		}
	}
}

