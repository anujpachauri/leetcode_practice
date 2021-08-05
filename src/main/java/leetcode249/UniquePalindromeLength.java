package leetcode249;

import java.util.Arrays;

/**
 * @author Anuj Pachauri
 *
4:34:43 pm
05-Aug-2021
 */
public class UniquePalindromeLength {

	public int countPalindromicSubSequence(String s) {

		int n = s.length();

		char[] chrArr = s.toCharArray();

		int[] firstOcc = new int[26];

		int[] lastOcc = new int[26];

		Arrays.fill(firstOcc, -1);
		Arrays.fill(lastOcc, -1);

		for (int i = 0; i < n; i++) {

			char c = chrArr[i];
			
			if (firstOcc[c - 'a'] == -1) {
				firstOcc[c - 'a'] = i;
			}
			lastOcc[c - 'a'] = i;
		}

		int ans = 0, count = 0;

		boolean[] visited;

		for (int i = 0; i < 26; i++) {

			int si = firstOcc[i];
			int ei = lastOcc[i];

			visited = new boolean[26];

			count = 0;
			
			
			
			for(int j=si+1;j<ei;j++) {
				
				if (!visited[chrArr[j] - 'a']) {
					visited[chrArr[j] - 'a'] = true;
					count++;
					
				}
			}
			ans += count;

		}

		return ans;
	}
}
