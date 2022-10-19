package util;

public class StringCompare {
	public int compareTo(String a, String b) {
		int length = a.length() > b.length() ? b.length() : a.length();
		
		for(int i = 0; i < length; i++) {
			if(a.charAt(i) == b.charAt(i)) {
				continue;
			}
			return (a.charAt(i) - b.charAt(i) > 0) ? 1 : -1;
		}
		
		return a.length() == b.length() ? 0 : a.length() > b.length() ? 1 : -1;
	}
}
