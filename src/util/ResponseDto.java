package util;

public class ResponseDto<T> {
	
	private final String code;
	
	private final String message;
	
	private final T data;

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}
	
	public ResponseDto(String code, String message, T data){
		this.code = code;
		this.message = message;
		this.data = data;
	}
}