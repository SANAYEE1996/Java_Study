package cleanCode.chapter12;

public class JapanVacationPolicy extends VacationPolicy{

	@Override
	protected void alterForLegalMinimums() {
		System.out.println("It is Japan Legal");
	}

}
