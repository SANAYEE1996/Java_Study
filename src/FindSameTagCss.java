import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class FindSameTagCss {
	
	void readCssLine(BufferedReader br, ArrayList<String> tagList) throws IOException {
        String line;
        int index = 0;
        HashSet<String> set = new HashSet<>();
        while(true) {
            line = br.readLine();
            if (line==null) break;  // 더 이상 읽을 라인이 없을 경우 while 문을 빠져나간다.
            index = line.indexOf("https");
            if(index > 0) {
            	line = line.substring(index);
            	index = line.indexOf(")");
            	line = line.substring(0,index);
            	tagList.add(line);
            	set.add(line);
            }
        }
        
        br.close();
	}
	
	
	
	public static void main(String[] args) throws IOException {
        
        BufferedReader classBr = new BufferedReader(new FileReader("C:/Users/imaxsoft-21/Desktop/Nanumsgothic.txt"));
        //BufferedReader adminBr = new BufferedReader(new FileReader("C:/Users/imaxsoft-16/Desktop/adminCss.txt"));
        FindSameTagCss s = new FindSameTagCss();
        ArrayList<String> classTagList = new ArrayList<>();
        //ArrayList<String> adminTagList = new ArrayList<>();
        s.readCssLine(classBr,classTagList);
        //s.readCssLine(adminBr,adminTagList);
        
//        ArrayList<String> duplicateList = new ArrayList<>();
//        for(String str : classTagList) {
//        	if(adminTagList.contains(str) && !duplicateList.contains(str)) {
//        		duplicateList.add(str);
//        	}
//        }
//        for(String str : duplicateList) {
//        	System.out.println(str);
//        }
        
        
	}
}
