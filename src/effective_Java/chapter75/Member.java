package effective_Java.chapter75;

public class Member {
	private String name;
	
	private int age;
	
	private String email;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}
	
	public Member(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}
	
	public static Member create(String name, int age, String email) {
		if(!email.contains("@")) {
			throw new RuntimeException("message = '이메일에 @가 없습니다', fieldname = 'email', inputValue = '"+email+"'");
		}
		return new Member(name, age, email);
	}
}
