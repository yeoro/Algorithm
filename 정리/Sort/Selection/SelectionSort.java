import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		
		int[] nums = {1000, 400, 12, -59, 328, 121, -3};
		int size = nums.length;
		
		for(int i = 0; i < size; i++) {
			int minIdx = i;
			for(int j = i; j < size; j++) {
				if(nums[minIdx] > nums[j]) {
					minIdx = j;
				}
			}
			
			if(minIdx != i) {
				int temp = nums[i];
				nums[i] = nums[minIdx];
				nums[minIdx] = temp;
			}
		}
		
		System.out.println(Arrays.toString(nums));
	}
}
