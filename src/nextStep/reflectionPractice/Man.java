package nextStep.reflectionPractice;

public class Man extends Person{
	
	public long strength;
	
	public Man() {
		this.age = 20;
		this.strength = 100;
	}
	
	public void strength() {
		System.out.println("힘 증가");
	}
	
	public void strengthUp() {
		strength++;
	}
	
	public boolean isMan(String sexualityCode) {
		if(sexualityCode.toUpperCase().equals("MAN")) {
			return true;
		}
		return false;
	}
	
	public void shout() {
		military();
		System.out.println("i am man!!");
	}
	
	private void military() {
		System.out.println("in korea, man must play call of duty");
	}
}
