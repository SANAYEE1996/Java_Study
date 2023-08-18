package paint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindJSP {
	private void readAndAddAndPut(BufferedReader br, List<String> list) throws IOException {
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
        }
        
        br.close();
	}
	
	public static void main(String[] args) throws IOException {
		FindJSP s = new FindJSP();
		BufferedReader classBr = new BufferedReader(new FileReader("../allJsp.txt"));
		
		List<String> jspList = new ArrayList<>();
		s.readAndAddAndPut(classBr, jspList);
		System.out.println(jspList.size());
		for(String str : jspList) {
			System.out.println(str);
		}
	}
}
