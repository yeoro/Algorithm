package Softeer_level3_조립라인;

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] A = new int[N+1][N+1];
		int[][] B = new int[N+1][N+1];
		int[][] dp = new int[3][N+1];

		int min = Integer.MAX_VALUE;

		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			dp[1][i] = Integer.parseInt(st.nextToken());
			dp[2][i] = Integer.parseInt(st.nextToken());

			A[i][i+1] = Integer.parseInt(st.nextToken());
			B[i][i+1] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		dp[1][N] = Integer.parseInt(st.nextToken());
		dp[2][N] = Integer.parseInt(st.nextToken());

		for(int i = 2; i <= N; i++) {
			dp[1][i] = Math.min(dp[1][i-1], dp[2][i-1] + B[i-1][i]) + dp[1][i];
			dp[2][i] = Math.min(dp[2][i-1], dp[1][i-1] + A[i-1][i]) + dp[2][i];
		}

		for(int i = 1; i <= 2; i++) {
			min = Math.min(min, dp[i][N]);
		}

		System.out.println(min);

		br.close();
	}
}