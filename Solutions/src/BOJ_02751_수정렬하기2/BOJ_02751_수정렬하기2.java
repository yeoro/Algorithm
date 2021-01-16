package BOJ_02751_수정렬하기2;

import java.util.Scanner;

public class BOJ_02751_수정렬하기2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N];
		int size = N-1;
		
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(nums[j] > nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;					
				}
			}
		}
		
		for(int i : nums) {
			System.out.println(i);
		}
		
		sc.close();
	}
}

