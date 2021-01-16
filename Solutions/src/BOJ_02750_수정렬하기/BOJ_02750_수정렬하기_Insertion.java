package BOJ_02750_수정렬하기;

import java.util.Scanner;

public class BOJ_02750_수정렬하기_Insertion {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N];
		int size = N;
		
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		for(int i = 1; i < size; i++) {
			for(int j = i-1; j >= 0; j--) {
				if(nums[j] > nums[j+1]) {
					int temp = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = temp;
				} 
			}
		}
		
		for(int i : nums) {
			System.out.println(i);
		}
		
		sc.close();
	}
}

