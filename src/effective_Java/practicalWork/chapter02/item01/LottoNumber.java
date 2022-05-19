package effective_Java.practicalWork.chapter02.item01;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	private static Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();
	
	static {
		IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
		.forEach(i -> lottoNumberCache.put(i, new LottoNumber(i)));
	}

	private int number;

	private LottoNumber(int number) {
		this.number = number;
	}  
}
