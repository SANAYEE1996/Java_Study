package util;

public class ResponseDto<T> {
	
	private String code;
	
	private String message;
	
	private T data;

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}
	
	public ResponseDto() {
		
	}
	
	public ResponseDto(String code, String message, T data){
		this.code = code;
		this.message = message;
		this.data = data;
	}
}