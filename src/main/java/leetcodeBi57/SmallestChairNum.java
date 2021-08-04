package leetcodeBi57;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author Anuj Pachauri
 *
1:58:34 pm
04-Aug-2021
 */
public class SmallestChairNum {

	public int smallestChairNum(int[][] times, int targetFriend) {

		ArrayList<int[]> list = new ArrayList<>();

		for (int i = -0; i < times.length; i++) {
			list.add(new int[] { i, 0 });
			list.add(new int[] { i, 1 });
		}

		Collections.sort(list,
				(a, b) -> times[a[0]][a[1]] == times[b[0]][b[1]] ? b[1] - a[1] : times[a[0]][a[1]] - times[b[0]][b[1]]);

		HashMap<Integer, Integer> map = new HashMap<>();
		TreeSet<Integer> set = new TreeSet<>();
		for (int[] i : list) {
			if (i[1] == 0) {
				map.put(i[0], set.isEmpty() ? map.size() : set.pollFirst());
				if (i[0] == targetFriend) {
					return map.get(i[0]);
				}
			} else {
				set.add(map.remove(i[0]));
			}
		}
		return 0;
	}
}
