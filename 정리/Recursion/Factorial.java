package day01_recursive;
import java.util.Scanner;

public class Factorial {
	
	private static long factorial(int n) {
		// 기저(재귀 탈출)
		if(n == 1) {
			return 1;
		}
		
		// 유도(파생)
		return n * factorial(n - 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(factorial(N));
		
		sc.close();
	}
}
