import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convert {
	public static List<String> convert(List<Object> input) {
	 	List<String> output = new ArrayList<>();
	 	String a = "";
		for(Object i : input) {
			a = i.getClass().getTypeName().toString().substring(10);
			if(a.equals("String")) {
				output.add(i.toString());
			} 
			else {
				gogo(output, (Object[]) i);
			} 
		}
		return output;
	}
	
	public static void gogo(List<String> output, Object[] ob) {
		String a = "";
		for(Object i : ob) {
			a = i.getClass().getTypeName().toString().substring(10);
			if(a.equals("String")) {
				output.add(i.toString());
			}
			else {
				gogo(output, (Object[]) i);
			}
		}
	}
	
	private String getAnswer(String s) {
		String[] strArray = s.split("\\.");
		if(strArray[1].equals("0")) {
			return strArray[0];
		}
		return strArray[0] + "  " + strArray[1];
	}
	
	public static void main(String[] args) {
		System.out.println((double)4/333);
		System.out.println((double)1/2);
		System.out.println((double)2/1);
		System.out.println((double)Math.sqrt(2));
		Convert s = new Convert();
		String a = String.valueOf((double)4/333);
		System.out.println(s.getAnswer(a));
		
		a = String.valueOf((double)1/2);
		System.out.println(s.getAnswer(a));
		
		a = String.valueOf((double)2/1);
		System.out.println(s.getAnswer(a));
		
		a = String.valueOf((double)Math.sqrt(2));
		System.out.println(s.getAnswer(a));
	}
}
