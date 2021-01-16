import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {

		int[] nums = {1000, 400, 12, -59, 328, 121, -3};
		 
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums.length-1; j++) {
				if(nums[j] > nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(nums));
	}
}
