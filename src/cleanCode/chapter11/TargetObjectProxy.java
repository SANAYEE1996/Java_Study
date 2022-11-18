package cleanCode.chapter11;

public class TargetObjectProxy implements TargetObject{
	TargetObjectImpl subject;
	
	{
		subject = new TargetObjectImpl();
	}
	
	@Override
	public String someMethod(String name) {
		System.out.println("Before Proxy \n");
		return subject.someMethod(name) + "After Proxy\n";
	}
}
