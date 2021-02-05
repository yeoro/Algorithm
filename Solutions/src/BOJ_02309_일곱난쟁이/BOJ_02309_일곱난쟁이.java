/*
1
2
10
10
10
10
10
48
49
 */
package BOJ_02309_¿œ∞ˆ≥≠¿Ô¿Ã;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_02309_¿œ∞ˆ≥≠¿Ô¿Ã {

	static int[] dwarf, real;
	static int cnt;
	static boolean check;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		dwarf = new int[9];
		real = new int[7];
		
		for(int i = 0; i < 9; i++) {
			dwarf[i] = sc.nextInt();
		}
		
		Arrays.sort(dwarf);
		
		solve(0, 0, 0);
		
		sc.close();
	}
	
	private static void solve(int n, int r, int height) {
		if(r == 7 && height == 100) {
			if(!check) {
				for(int i = 0; i < r; i++) {
					System.out.println(real[i]);
				}
			}
			check = true;
			return;
		}
		
		if(n >= 9 || r >= 7) {
			return;
		}
		
		// º±≈√
		real[r] = dwarf[n];
		solve(n+1, r+1, height+dwarf[n]);
		
		// ∫Òº±≈√
		solve(n+1, r, height);
		
	}
}

