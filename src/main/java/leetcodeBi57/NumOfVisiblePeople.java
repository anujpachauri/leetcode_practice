package leetcodeBi57;

import java.util.Stack;

/**
 * @author Anuj Pachauri
 *
6:00:24 pm
04-Aug-2021
 */
public class NumOfVisiblePeople {

	public int[] canSeePeople(int[] heights) {

		int n = heights.length, res[] = new int[n];

		Stack<Integer> stack = new Stack();

		for (int i = 0; i < n; i++) {

			while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
				res[stack.pop()]++;
			}
			if (!stack.isEmpty()) {
				res[stack.peek()]++;
			}
			stack.add(i);

		}

		return res;
	}
}
