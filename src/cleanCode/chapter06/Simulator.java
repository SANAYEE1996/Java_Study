package cleanCode.chapter06;


public class Simulator {
	public static void main(String[] args) {
		
		Address seoul = new Address("seoul", "the center of south korea");
		
		User park = new User("park dragon", 25, seoul);
		
		System.out.println(park.isSeoulRegionPerson());
				
		
		
	}
	
}
