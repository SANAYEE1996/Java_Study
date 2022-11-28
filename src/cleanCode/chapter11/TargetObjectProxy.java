package cleanCode.chapter11;

public class TargetObjectProxy implements TargetObject{
	TargetObjectImpl subject;
	
	{
		subject = new TargetObjectImpl();
	}
	
	@Override
	public void someMethod(String name) {
		System.out.println("Before Proxy \n");
		System.out.println("After Proxy : ");
		subject.someMethod(name);
	}
}
