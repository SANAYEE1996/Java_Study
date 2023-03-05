package cleanCode.chapter12;

public abstract class VacationPolicy {
	
	public VacationPolicy() {
		calculatedBaseVacationHours();
		alterForLegalMinimums();
		applyToPayroll();
	}
	
	private void calculatedBaseVacationHours() {
		System.out.println("calculate Base VataionHours");
	}
	
	abstract protected void alterForLegalMinimums();
	
	private void applyToPayroll() {
		System.out.println("apply Pay Roll");
	}
}
