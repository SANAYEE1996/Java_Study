package reactive.chapter04;

import java.util.Collections;
import java.util.List;

public class Example4_4 {
	public static void main(String[] args) {
		List<CryptoCurrency> list = SampleData.cryptoCurrencies;
		
		Collections.sort(list, (cc1, cc2) -> cc1.getUnit().name().compareTo(cc2.getUnit().name()));
		
		for(CryptoCurrency c : list) {
			System.out.println("name : " +c.getName()+ " price : " +c.getUnit());
		}
	}
}
