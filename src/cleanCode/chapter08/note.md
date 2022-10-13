프로그램에서 Map<K,V> 인스턴스를 여기저기로 넘긴다면, Map 인터페이스가 변할 경우, 수정할 코드가 상당히 많아진다.
인터페이스가 변할 가능성이 거의 없다고 여길지도 모르지만, 자바5가 제네릭스를 지원하면서 Map 인터페이스가 변했다는 사실을 명심해야 한다.
Map 클래스를 사용할 때 마다 위와 같이 캡슐화 하라는 소리는 아니다.
Map을 여기저기 넘기지 말라는 뜻이다.
Map과 같은 경계 인터페이스를 이용할 때는 이를 이용하는 클래스나 클래스 계열 밖으로 노출되지 않도록 주의한다.
Map 인스턴스를 고애 API의 인수로 넘기거나 반환값으로 사용하지 않도록 주의한다.