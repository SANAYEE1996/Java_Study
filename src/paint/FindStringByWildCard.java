package paint;

import java.util.HashMap;
import java.util.Map;

public class FindStringByWildCard {
	
	public boolean isMatch(String word, String pattern) {
		Map<String, Boolean> lookup = new HashMap<>();
		System.out.println("pattern : " +pattern);
		return isMatch(word, 0, pattern, 0, lookup);
	}
	
	private boolean isMatch(String word, int n, String pattern, int m, Map<String, Boolean> lookup) {
		String key = n + "|" + m;
		if (lookup.containsKey(key)) {
			return lookup.get(key);
		}
		if (m == pattern.length()) {
			lookup.put(key, (n == word.length()));
			return n == word.length();
		}
		if (n == word.length()) {
			for (int i = m; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*') {
					lookup.put(key, false);
					return false;
				}
			}
			lookup.put(key, true);
			return true;
		}
		if (pattern.charAt(m) == '?' || pattern.charAt(m) == word.charAt(n)) {
			lookup.put(key, isMatch(word, n + 1, pattern, m + 1, lookup));
		}
		else if (pattern.charAt(m) == '*') {
			lookup.put(key, isMatch(word, n + 1, pattern, m, lookup) || isMatch(word, n, pattern, m + 1, lookup));
		} else {
			lookup.put(key, false);
		}
		return lookup.get(key);
	}

}
