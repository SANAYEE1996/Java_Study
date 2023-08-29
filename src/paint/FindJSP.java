package paint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FindJSP {
	private void readAndAddAndPut(BufferedReader br, List<String> list, Set<String> set) throws IOException {
        String line;
        String head = "";
        while(true) {
            line = br.readLine();
            if (line==null) break; 
            if(line.equals("")) {
            	continue;
            }
            else if(line.contains("/WEB-INF/")) {
            	head = line;
            	continue;
            }
            list.add(head+line);
            set.add(head+line);
        }
        
        br.close();
	}
	
	private void deleteDuplicateString(BufferedReader br, List<String> list, Set<String> set) throws IOException{
		String line;
        while(true) {
            line = br.readLine();
            if (line==null) break;
            list.add(line);
            set.add(line);
        }
        
        br.close();
	}
	
	public static void main(String[] args) throws IOException {
		FindJSP s = new FindJSP();
		BufferedReader classBr = new BufferedReader(new FileReader("C:/Users/.../Desktop/textMemo/allJsp.txt"));
		
		List<String> jspList = new ArrayList<>();
		Set<String> set = new HashSet<>();
		s.readAndAddAndPut(classBr, jspList, set);
		System.out.println(jspList.size());
		System.out.println(jspList.size() == set.size());
		for(String str : jspList) {
			System.out.println(str);
		}
		System.out.println("\n\n\n\n==============================================================");
		classBr = new BufferedReader(new FileReader("C:/Users/.../Desktop/textMemo/html_lang.txt"));
		jspList = new ArrayList<>();
		set = new HashSet<>();
		s.deleteDuplicateString(classBr, jspList, set);
		
		System.out.println(jspList.size() == set.size());
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
