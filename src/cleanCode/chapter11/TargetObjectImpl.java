package cleanCode.chapter11;

public class TargetObjectImpl implements TargetObject{
	@Override
	public String someMethod(String name) {
		return "method name is : "+name+"\n";
	}
}
