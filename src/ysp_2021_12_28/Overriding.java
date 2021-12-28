package ysp_2021_12_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Overriding {

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

	public static void main(String[] args) {
		List<Object> head = new ArrayList<>();
		Object[] b = {"b"};
		Object[] ab = new Object[2];
		Object[] de = {"d","e"};
		ab[0] = "a";
		ab[1] = b;
		head.add(ab);
		List<Object> input = new ArrayList<>(head);
		input.add("c");
		input.add(de);
		System.out.println(input);
		System.out.println(convert(input));
		
		
		System.out.println();
		//{{a,{b}},c,{d,e},f,{g,{h}},i};
		int[][] jobs ={	{24, 10}, 
				{28, 39}, 
				{43, 20}, 
				{37, 5}, 
				{47, 22}, 
				{20, 47}, 
				{15, 34}, 
				{15, 2}, 
				{35, 43}, 
				{26, 1}};
		
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int [] b) {
				if(a[0] == b[0]) return a[1] - b[1];
				else return a[0] - b[0];
				
			}
		});
		
		for (int[] i : jobs) System.out.println(Arrays.toString(i)); 

	}

}
