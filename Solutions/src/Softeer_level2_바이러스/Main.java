package Softeer_level2_바이러스;

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long K = Long.parseLong(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		for(int i = 1; i <= N; i++) {
			K *= P;
			K %= 1000000007;
		}

		System.out.println(K);

		br.close();
	}
}