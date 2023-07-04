Item 34. int 상수 대신 열거 타입을 사용하라.
=====================================

상수별 메서드 구현에는 열거 타입 상수끼리 코드를 공유하기 어렵다는 단점이 있다.<br>
밑의 코드는 급여 명세서에 쓸 요일을 표현하는 열거타입을 예로 한 코드이다.<br>
이 열거 타입은 직원의 시간당 기본 임금과 그날 일한 시간(분 단위)이 주어지면<br>
일당을 계산해주는 메서드를 가지고 있다.<br>
주중에 오버타임이 발생하면 잔업 수당이 주어지고, 주말에는 무조건 잔업수당이 주어진다.<br>
switch 문을 이용해 case문을 날짜별로 두어 계산을 쉽게 수행하도록 했다.<br>

```java
enum PayrollDay{
	MONDAY, TUESDAT, WENDSDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	
	private static final int MINS_PER_SHIFT = 8*60;
	
	int pay(int minutesWorked, int payRate){
		int basePay = minutesWorked*payRate;
	
		int overtimePay;
		switch(this){
			case SATURDAY: case SUNDAY:
				overtimePay = basePay
				break;
			default:
				overtimePay = minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked-MINS_PER_SHIFT)*payRate/2;
		}
		
		return basePay + overtimePay;
	}
}
```

간결하지만, 관리관점에서는 위험한 코드.<br>
휴가와 같은 새로운 값을 열거 타입에 추가하려면 그 값을 처리하는 case 문을 잊지 말고 쌍으로 넣어줘야 한다.<br>
자칫 깜빡하는 날에는 휴가 기간에 열심히 일해도 평일과 똑같은 임금을 받게 될 것이다.<br>
물론 프로그램은 말끔히 컴파일 되고 잘 돌아가기까지 해서 더 문제다.
-------------

PayrollDay <br>
전략 열거 타입 패턴.
가장 깔끔한 방법으로 새로운 상수를 추가할 때 잔업수당 '전략'을 선택하도록 하는 것이다. <br>
잔업수당 곗나을 private  중첩 열거 타입으로 옮기고 PayrollDay 열거 타입의 생성자에서 이 중 적당한 것을 선택한다. <br>
그러면 PayrollDay 열거 타입은 잔업수당 계산을 그 전략 열거 타입에 위임하여, <br>
switch 문이나 상수별 메서드 구현이 필요없게 된다. <br>
이 패턴은 switch 문보다 복잡하지만 더 안전하고 유연하다.

<br>

#그러면 열거타입을 과연 언제 쓰면 되는 걸까?
**필요한 원소를 컴파일 타임에 다 알 수 있는 상수 집합이라면 항상 열거타입을 사용하자.**<br>
**열거 타입에 정의된 상수 개수가 영원히 고정 불변일  필요는 없다.**<br>
열거 타입은 나중에 상수가 추가되어도 바이너리 수준에서 호환되도록 설계되었다.

#[정리]
**열거타입은 확실히 정수 상수보다 뛰어나다. 더 읽기 쉽고 안전하고 강력하다.** <br>
**대다수 열거타입이 명시적 생성자나 메서드 없이 쓰이지만,** <br>
**각 상수를 특정 데이터와 연결짓거나 상수마다 다르게 동작하게 할 때는 필요하다.** <br>
**드물게는 하나의 메서드가 상수별로 다르게 동작해야 할 때도 있다.** <br>
**이런 열거 타입에서는 switch 문 대신 상수별 메서드 구현을 사용하자.** <br>
**열거 타입 상수 일부가 같은 동작을 공유한다면 전략 열거타입 패턴을 사용하자.** <br>

