package cleanCode.chapter06;

public class Address {
	private String region;
	private String details;
	
	public Address(String region, String details) {
		this.region = region;
		this.details = details;
	}
	
	public boolean isSeoulRegion() {
		return this.region.equals("seoul");
	}
	
	public void getRegionDetails() {
		System.out.println(details);
	}
}
