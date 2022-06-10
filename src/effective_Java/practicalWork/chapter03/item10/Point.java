package effective_Java.practicalWork.chapter03.item10;

public class Point {
	private final int x;
	private final int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override public boolean equals(Object o) {
		if(!(o instanceof Point)) return false;	//Point 객체는 Object 객체의 하위임을 명시
		Point p = (Point)o;
		return p.x == x && p.y == y;
	}
}

//equals 재정의 - 추이성 위반
