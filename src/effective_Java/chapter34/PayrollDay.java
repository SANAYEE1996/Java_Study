package effective_Java.chapter34;

public enum PayrollDay {
	
	MONDAY(PayType.WEEKDAY),
	TUESDAY(PayType.WEEKDAY),
	WENDSDAY(PayType.WEEKDAY),
	THURSDAY(PayType.WEEKDAY),
	FRIDAY(PayType.WEEKDAY),
	SATURDAY(PayType.WEEKEND),
	SUNDAY(PayType.WEEKEND);

	private final PayType payType;
	
	PayrollDay(PayType payType) {
		this.payType = payType;
	}
	
	public int pay(int minsWorked, int payRate) {
		return payType.pay(minsWorked, payRate);
	}
	
	enum PayType{
		WEEKDAY{
			int overtimePay(int minsWorked, int payRate){
				return minsWorked <= MINS_PER_SHIFT ? 0 : (minsWorked - MINS_PER_SHIFT) * payRate / 2;
			}
		},
		WEEKEND{
			int overtimePay(int minsWorked, int payRate){
				return minsWorked * payRate / 2;
			}
		};
		
		abstract int overtimePay(int mins, int payRate);
		private static final int MINS_PER_SHIFT = 8 * 60;
		
		int pay(int minsWorked, int payRate) {
			return minsWorked*payRate + overtimePay(minsWorked, payRate);
		}
	}
}
