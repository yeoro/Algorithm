package BOJ_02750_수정렬하기;

import java.util.Scanner;

public class BOJ_02750_수정렬하기_Quick {

	static int[] nums;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		nums = new int[N];
		int size = N-1;
		
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		quickSort(0, size);
		
		for(int i : nums) {
			System.out.println(i);
		}
		
		sc.close();
	}
	

	static void quickSort(int start, int end) {

		if(start > end) {
			return;
		}
		
		int pivot = start;
		int left = start + 1;
		int right = end;
		
		while(left <= right) {
			while(left <= end && nums[pivot] >= nums[left]) {
				left++;
			}
			while(right > start && nums[pivot] <= nums[right]) {
				right--;
			}
			if(left < right) {
				swap(left, right);
			}
		}
		
		swap(right, pivot);
		
		quickSort(start, pivot-1);
		quickSort(pivot+1, end);
	}
	
	static void swap(int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}

