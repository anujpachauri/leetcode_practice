package leetcodeBi57;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author Anuj Pachauri
 *
1:22:38 pm
04-Aug-2021
 */
public class SameFrequency {

	public boolean areOccurance(String s) {

		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int f = map.get(s.charAt(0));
		for (char c : map.keySet()) {
			if (map.get(c) != f) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void testAreOcrrurance() {

		String s = "aabcbc";
		assertTrue(areOccurance(s));
	}
}
