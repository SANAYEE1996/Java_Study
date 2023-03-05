package cleanCode.chapter12;

public class KoreanVataionPolicy extends VacationPolicy{

	@Override
	protected void alterForLegalMinimums() {
		System.out.println("It is korean LegalMinums");
	}
	
}
