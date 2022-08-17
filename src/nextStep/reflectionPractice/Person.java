package nextStep.reflectionPractice;

public class Person {
	int age;
	String name;
	
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
}
