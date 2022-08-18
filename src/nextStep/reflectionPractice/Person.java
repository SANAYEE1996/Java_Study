package nextStep.reflectionPractice;

public class Person {
	public int age;
	private String name;
	
	public Person() {
		this.age = 0;
		this.name = "unknown";
	}
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	protected Person(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getString() {
		return name;
	}
	
	public void print(int age, String name) {
		System.out.println("나이 : " +age +" ,이름 : "+name);
	}
}
