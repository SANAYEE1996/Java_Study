package cleanCode.chapter11;

public class PureProxyClient {
	
	public void run(String name) {
		TargetObjectProxy proxy = new TargetObjectProxy();
		System.out.println(proxy.someMethod(name));
	}
	
	public static void main(String[] args) {
		PureProxyClient client = new PureProxyClient();
		client.run("Park");
	}
}
