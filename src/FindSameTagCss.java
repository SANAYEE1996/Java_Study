import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindSameTagCss {
	public static void main(String[] args) throws IOException {
        
        BufferedReader classBr = new BufferedReader(new FileReader("C:/Users/imaxsoft-16/Desktop/classCss.txt"));
        int count = 0;
        int index = 0;
        String beforeLine;
        while(true) {
            String line = classBr.readLine();
            count++;
            if (line==null) break;  // 더 이상 읽을 라인이 없을 경우 while 문을 빠져나간다.
            index = line.length();
            beforeLine = line;
            if(line.contains("{") && !line.contains("@")) {
            	index = line.indexOf("{");
            	if(!line.contains("}")) {
            		while(true) {
	            		line = classBr.readLine();
	            		if(line.contains("}")) {
	            			break;
	            		}
	            	}
            	}
            }
            System.out.println(beforeLine.substring(0,index));
        }
        System.out.println("전체 줄 수 : " +count);
        classBr.close();
        
        BufferedReader adminBr = new BufferedReader(new FileReader("C:/Users/imaxsoft-16/Desktop/adminCss.txt"));
        
        while(true) {
            String line = adminBr.readLine();
            count++;
            if (line==null) break;  // 더 이상 읽을 라인이 없을 경우 while 문을 빠져나간다.
        }
        System.out.println("전체 줄 수 : " +count);
        adminBr.close();
	}
}
