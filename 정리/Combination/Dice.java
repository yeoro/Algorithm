import java.util.Arrays;
import java.util.Scanner;

public class Dice {

	static int[] number;
	static boolean[] v;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 선택할 숫자 개수
		int M = sc.nextInt(); // 종류 선택
		
		number = new int[N];
		v = new boolean[6];
		
		switch(M) {
		case 1:
			/**
			 * 중복순열 : 주사위를 N번 던져서 같은 수 여러 번 선택
			 * 11, 12, 13, ... , 21, 22, 23, ... , 61, 62, ... , 66
			 */
			repermutation(0);
			break;
		case 2:
			/**
			 * 순열 : 주사위를 N번 던져서 중복없이 선택
			 * 12, 13, 14, ... , 21, 23, 24, ... , 61, 62, ... , 65
			 */
			permutation(0);
			break;
		case 3:
			/**
			 * 중복조합 : 주사위를 N번 던져서 같은 수를 여러 번 선택, 비내림차순
			 * 11, 12, 13, ... , 22, 23, 24, ... , 66
			 */
			recombination(0, 1);
			break;
		case 4:
			/**
			 * 조합 : 주사위를 N번 던져서 중복없이 선택, 오름차순의 수열 (선택된 수의 다음 위치부터 선택)
			 * 12, 13, 14, ... , 23, 24, 25, ... , 56
			 */
			combination(0, 1);
			break;
		}
		
		sc.close();
	}
	
	private static void repermutation(int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for(int i = 1; i <= 6; i++) {
			number[cnt] = i;
			repermutation(cnt+1);
		}
	}
	
	private static void permutation(int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for(int i = 1; i <= 6; i++) {
			if(v[i-1]) {
				continue;
			}
			
			v[i-1] = true;
			number[cnt] = i;
			permutation(cnt+1);
			v[i-1] = false;
		}
	}
	
	private static void recombination(int cnt, int cur) {
		if(cnt == N) {
			System.out.println(Arrays.toString(number));
			return;
		}
		
		if(cur > 6) {
			return;
		}
		
		for(int i = cur; i <= 6; i++) {
			number[cnt] = i;
			recombination(cnt+1, i);
		}
	}
	
	private static void combination(int cnt, int cur) {
		if(cnt == N) {
			System.out.println(Arrays.toString(number));
			return;
		}
		
		if(cur > 6) {
			return;
		}
		
		for(int i = cur; i <= 6; i++) {
			number[cnt] = i;
			recombination(cnt+1, i+1);
		}
	}

}
