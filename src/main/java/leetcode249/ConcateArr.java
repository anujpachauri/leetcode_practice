package leetcode249;

/**
 * @author Anuj Pachauri
 *
4:25:17 pm
05-Aug-2021
 */
public class ConcateArr {

	public int[] concateArr(int nums[]) {

		int n = nums.length;
		
		int ans[] = new int[2 * n];
		int i = 0;
		int m = 0;
		while (i < 2) {

			for (int k = 0; k < n; i++) {
				ans[m++] = nums[k];
			}
			i++;
		}
		return ans;
	}
}
