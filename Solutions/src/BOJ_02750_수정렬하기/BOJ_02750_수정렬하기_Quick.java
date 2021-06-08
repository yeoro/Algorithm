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
	

	static void quickSort(int left, int right) {
		if(left >= right) {
			return;
		}
		
		int pivot = partition(left, right);
		
		quickSort(left, pivot-1);
		quickSort(pivot+1, right);
	}
	
	static int partition(int left, int right) {
		int pivot = nums[left];
		int i = left, j = right;
		
		while(i < j) {
			while(pivot < nums[j]) {
				j--;
			}
			
			while(i < j && pivot >= nums[i]) {
				i++;
			}
			
			
			swap(i, j);
		}
		
		nums[left] = nums[i];
		nums[i] = pivot;
		
		return i;
	}
	
	static void swap(int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}

