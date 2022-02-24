import java.util.ArrayList;
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
}
