package BOJ_17471_게리맨더링;

import java.io.*;
import java.util.*;

public class BOJ_17471_게리맨더링 {
	
	static LinkedList<Integer>[] adj;
	static LinkedList<Integer>[] zone;
	static int[] population;
	static boolean[] v, vConnect;
	static int N, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		v = new boolean[N+1];

		// 지역 인구수 저장
		population = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		// 지역 연결 정보 저장
		adj = new LinkedList[N+1];
		for(int i = 1; i <= N; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int cnt = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < cnt; j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		divide(1);
		
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
		
		br.close();
	}
	
	private static void divide(int cur) {
		if(cur > N) {
			return;
		}
		
		zone = new LinkedList[2];
		// 선거구 리스트 초기화
		for(int i = 0; i < 2; i++) {
			zone[i] = new LinkedList<Integer>();
		}
		
		// 선거구 나누기
		for(int i = 1; i <= N; i++) {
			if(v[i]) {
				zone[0].add(i);
			} else {
				zone[1].add(i);
			}
		}
		
		// 선거구는 적어도 하나의 지역을 포함해야 함
		if(zone[0].size() > 0 && zone[1].size() > 0) {
			// 선거구 내 지역들이 모두 연결되어야 함
			if(isConnect(zone[0]) && isConnect(zone[1])) {
				int sum1 = 0;
				int sum2 = 0;
				
				// 모두 연결되었다면 인구수 계산
				for(int i : zone[0]) {
					sum1 += population[i];
				}
				
				for(int i : zone[1]) {
					sum2 += population[i];
				}
				
				min = Math.min(min, Math.abs(sum1 - sum2));
			}
		}
		
		for(int i = cur; i <= N; i++) {
			if(!v[i]) {
				v[i] = true;
				divide(i+1);
				v[i] = false;
			}
		}
	}
	
	private static boolean isConnect(LinkedList<Integer> z) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(z.get(0));
		
		vConnect = new boolean[N+1];
		vConnect[z.get(0)] = true;
		boolean check = true;
		
		while(!q.isEmpty()) {
			int area = q.poll();
			
			for(int i = 0; i < z.size(); i++) {
				if(!vConnect[z.get(i)] && adj[area].contains(z.get(i))) {
					vConnect[z.get(i)] = true;
					q.add(z.get(i));
				}
			}
		}
		
		for(int i = 0; i < z.size(); i++) {
			if(!vConnect[z.get(i)]) {
				check = false;
				break;
			}
		}
		
		return check;
	}
}

