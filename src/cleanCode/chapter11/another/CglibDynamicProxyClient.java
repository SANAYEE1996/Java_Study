package cleanCode.chapter11.another;

//import java.lang.reflect.Method;

public class CglibDynamicProxyClient {
	public static void main(String[] args) {
        CglibDynamicProxyClient client = new CglibDynamicProxyClient();
        client.run("Lob");
    }

    public void run(String name) {

//        MethodInterceptor methodInterceptor = new MethodInterceptor() {
//            final TargetObject targetObject = new TargetObject();
//
//            @Override
//            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//                System.out.println("Before Proxy");
//                Object invoke = method.invoke(targetObject, args);
//                System.out.println("After Proxy");
//                return invoke;
//            }
//        };
//
//        TargetObject targetObject = (TargetObject) Enhancer.create(TargetObject.class, methodInterceptor);
//
//        targetObject.someMethod(name);
    }
}
