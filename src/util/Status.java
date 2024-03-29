package util;

public enum Status {
	OK("200", "OK"),
	ERROR("404", "ERROR");
	
	private final String code;
	private final String message;
	
	private Status(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String code() {
		return this.code;
	}
	
	public String message() {
		return this.message;
	}
}
