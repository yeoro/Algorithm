package Softeer_level2_지도자동구축;

import java.util.*;
import java.io.*;


public class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[16];

		dp[0] = 4;
		int mul = 0;

		for(int i = 1; i <= 15; i++) {
			double pre = Math.sqrt(dp[i-1]);
			double add = 1 * Math.pow(2, i-1);

			dp[i] = (int) ((pre+add) * (pre+add));
			
			mul++;
		}
		
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);

		br.close();
	}
}