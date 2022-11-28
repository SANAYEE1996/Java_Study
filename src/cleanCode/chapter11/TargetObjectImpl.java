package cleanCode.chapter11;

public class TargetObjectImpl implements TargetObject{
	@Override
	public void someMethod(String name) {
		System.out.println("Real Subject Do something " +name);
	}
}
