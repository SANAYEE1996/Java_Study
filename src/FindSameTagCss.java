import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FindSameTagCss {
	
	void readCssLine(BufferedReader br, ArrayList<String> tagList) throws IOException {
        int index = 0;
        String beforeLine;
        while(true) {
            String line = br.readLine();
            if (line==null) break;  // 더 이상 읽을 라인이 없을 경우 while 문을 빠져나간다.
            index = line.length();
            beforeLine = line;
            if(line.contains("@")) {
            	continue;
            }
            if(line.contains("{") && !line.contains("@")) {
            	index = line.indexOf("{");
            	if(!line.contains("}")) {
            		while(true) {
	            		line = br.readLine();
	            		if(line.contains("}")) {
	            			break;
	            		}
	            	}
            	}
            }
            beforeLine = beforeLine.substring(0, index).replaceAll("}", "").trim().replaceAll(",", "");
            if(beforeLine.equals("")) {
            	continue;
            }
            tagList.add(beforeLine);
        }
        
        br.close();
        System.out.println("태그 수 : " +tagList.size());
	}
	
	
	
	public static void main(String[] args) throws IOException {
        
        BufferedReader classBr = new BufferedReader(new FileReader("C:/Users/imaxsoft-16/Desktop/classCss.txt"));
        BufferedReader adminBr = new BufferedReader(new FileReader("C:/Users/imaxsoft-16/Desktop/adminCss.txt"));
        FindSameTagCss s = new FindSameTagCss();
        ArrayList<String> classTagList = new ArrayList<>();
        ArrayList<String> adminTagList = new ArrayList<>();
        s.readCssLine(classBr,classTagList);
        s.readCssLine(adminBr,adminTagList);
        
        ArrayList<String> duplicateList = new ArrayList<>();
        for(String str : classTagList) {
        	if(adminTagList.contains(str) && !duplicateList.contains(str)) {
        		duplicateList.add(str);
        	}
        }
        for(String str : duplicateList) {
        	System.out.println(str);
        }
        
        
	}
}
