package leetcode249;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Anuj Pachauri
 *
5:07:54 pm
05-Aug-2021
 */
public class PaintngGrid {
	static int mod = (int) 1e9 + 7;
	public int colorTheGrid(int m, int n) {

		Map<Integer, Long> state = new HashMap();
		dfs(state, 0, m, -1, 0);
		Set<Integer> set = new HashSet(state.keySet());
		for (int i = 1; i < n; ++i) {
			Map<Integer, Long> dp = new HashMap();
			for (int a : set) {
				for (int b : set) {
					if (0 == (a & b))
						dp.put(a, (dp.getOrDefault(a, 0L) + state.get(b)) % mod);
				}
			}
			state = dp;
		}
		long res = 0L;
		for (long val : state.values())
			res = (res + val) % mod;
		return (int) res;
	}

	private void dfs(Map<Integer, Long> state, int j, int m, int prev, int cur) {
		if (j == m) {
			state.put(cur, state.getOrDefault(cur, 0L) + 1);
			return;
		}
		for (int i = 0; i < 3; ++i) {
			if (i == prev)
				continue;
			dfs(state, j + 1, m, i, (cur << 3) | (1 << i));
		}
	}

}
