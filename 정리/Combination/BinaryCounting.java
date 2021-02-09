import java.util.Scanner;

public class BinaryCounting {

	static int N, totalCnt;
	static int[] input, number;
	static boolean[] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		input = new int[N];
		v = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		totalCnt = 1<<N; // 부분집합 비트열
		
		generateSubSet(totalCnt);
		
		System.out.println("총 경우의 수: " + totalCnt);
		
		sc.close();
	}
	
	private static void generateSubSet(int caseCnt) {
		for (int flag = 0; flag < caseCnt; flag++) {
			// flag 비트열별로 원소 수만큼 각 자리 비트 확인
			for(int i = 0; i < N; i++) {
				System.out.print(((flag & 1<<i) != 0 ? input[i] : "X") + " ");
			}
			System.out.println();
		}
	
	}

}
