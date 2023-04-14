package paint;

public class ExcelCheck {
	public Boolean isNumber(String str) {
		if(str == null || "".equals(str) ){
	      return false;
	    }
		String onlyNumberMatch = "[0-9]+";
		String containsOnlyOneComma = "^[^0]\\d*\\.{1}\\d*[^0]$";
		if(str.matches(onlyNumberMatch)) {
			return !str.startsWith("0");
		}
		return str.matches(containsOnlyOneComma);
	}
}
