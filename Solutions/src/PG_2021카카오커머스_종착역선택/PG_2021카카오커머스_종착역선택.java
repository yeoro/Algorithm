package PG_2021īī��Ŀ�ӽ�_����������;

import java.io.*;
import java.util.*;

public class PG_2021īī��Ŀ�ӽ�_���������� {
	
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
		
		// ��������Ʈ �ʱ�ȭ
		for(int i = 1; i <= n; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		
		// ��������Ʈ�� �� ���� ���� ���� ����
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
		// �� ������ ����� ������ ���� �̿밴 �� ����
		for(int i : adj[node]) {
			if(!v[i]) {
				v[i] = true;
				go(i, sum + p[i-1], p);
			}
			
			// �� �̻� �� ���� ���� ���̸� ���������� �Ǵ��ϰ� �ִ� �� �� ��ȣ ����
			if(max <= sum) {
				max = sum;
				if(station < node) {
					station = node;
				}
			}
		}
	}
}

