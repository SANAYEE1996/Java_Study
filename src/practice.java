

public class practice {
    public static void main(String[] args) {
    	System.out.println(System.identityHashCode(new String("string")));
    	System.out.println(System.identityHashCode(new String("string")));
    	
    	People p = new People();
    	System.out.println(System.identityHashCode(p));
    	System.out.println(System.identityHashCode(p.age(47)));
    	System.out.println(System.identityHashCode(new People().age(47)));
    	
    }
}
