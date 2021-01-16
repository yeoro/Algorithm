package BOJ_02751_수정렬하기2;

import java.util.Scanner;

public class BOJ_02751_수정렬하기2_Selection {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		for(int i = 0; i < nums.length; i++) {
			int minIdx = i;
			
			for(int j = i; j < nums.length; j++) {
				if(nums[minIdx] > nums[j]) {
					minIdx = j;
				}
			}
			
			if(minIdx != i) {
				int temp = nums[minIdx];
				nums[minIdx] = nums[i];
				nums[i] = temp;
			}
		}
		
		for(int i : nums) {
			System.out.println(i);
		}
		
		sc.close();
	}
}

