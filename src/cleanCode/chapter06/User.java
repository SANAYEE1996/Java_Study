package cleanCode.chapter06;

public class User {
	
	private String name;
	private int age;
	private Address address;
	
	public User(String name, int age, Address address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public boolean isSeoulRegionPerson() {
		return address.isSeoulRegion();
	}
}
