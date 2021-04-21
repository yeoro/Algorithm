package BOJ_11726_2Xn≈∏¿œ∏µ;

import java.io.*;
import java.util.*;

class Main {

	static int[] dp = new int[1001];
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		System.out.println(tile(n));
		
		br.close();
	}
	
	private static int tile(int n) {
		if(n == 1) {
			return 1;
		}
		
		if(n == 2) {
			return 2;
		}
		
		if(dp[n] != 0) {
			return dp[n];
		}
		
		return dp[n] = (tile(n-1) + tile(n-2)) % 10007;
	}
}

