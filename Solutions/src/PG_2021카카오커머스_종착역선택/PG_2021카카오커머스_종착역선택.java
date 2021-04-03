package PG_2021카카오커머스_종착역선택;

import java.io.*;
import java.util.*;

public class PG_2021카카오커머스_종착역선택 {
	
	static LinkedList<Integer>[] adj;
	static boolean[] v;
	static int max = Integer.MIN_VALUE, station = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		int n = 6;
		int[] passenger = {1, 1, 1, 1, 1, 1};
		int[][] train = {{1, 2}, {1, 3}, {1, 4},{3, 5}, {3, 6}};
		
		int[] answer = new int[2];
		
		adj = new LinkedList[n+1];
		v = new boolean[n+1];
		
		// 인접리스트 초기화
		for(int i = 1; i <= n; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		
		// 인접리스트에 역 간의 연결 정보 저장
		for(int i = 0; i < n-1; i++) {
			int station1 = train[i][0];
			int station2 = train[i][1];
			
			adj[station1].add(station2);
			adj[station2].add(station1);
		}
		
		v[1] = true;
		go(1, passenger[0], passenger);
		
		answer[0] = station;
		answer[1] = max;
		
		System.out.println(Arrays.toString(answer));
	}
	
	private static void go(int node, int sum, int[] p) {
		// 각 역에서 연결된 역으로 가며 이용객 수 구함
		for(int i : adj[node]) {
			if(!v[i]) {
				v[i] = true;
				go(i, sum + p[i-1], p);
			}
			
			// 더 이상 갈 곳이 없는 역이면 종착역으로 판단하고 최댓값 및 역 번호 갱신
			if(max <= sum) {
				max = sum;
				if(station < node) {
					station = node;
				}
			}
		}
	}
}

