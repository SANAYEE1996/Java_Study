package paint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckJsp {
	
	private void scanAllJsp(BufferedReader br, List<String> list) throws IOException{
		String header = "D:////webapp";
		String line;
        while(true) {
            line = br.readLine();
            if (line==null) break;
            if(checkContainsKeyword(new BufferedReader(new FileReader(header+line)), "")) {
            	System.out.println(line);
            }
        }
        br.close();
	}
	
	private boolean checkContainsHtml(BufferedReader br) throws IOException{
		String line;
		boolean isContain = true;
		int originCount = 0;
		int exceptionCount = 0;
        while(true) {
            line = br.readLine();
            if (line==null) break;
            if(line.contains("<input")) {
            	originCount++;
            }
            if( line.contains("type='button'") || 
            	line.contains("type=\"button\"") || 
            	line.contains("type='hidden'") ||
            	line.contains("type=\"hidden\"") ||
            	line.contains("type='submit'") ||
            	line.contains("type=\"submit\"") ||
            	line.contains("type='reset'") ||
            	line.contains("type=\"reset\"") ||
            	line.contains("type='image'") ||
            	line.contains("type=\"image\"") ) {
            	exceptionCount++;
            }
        }
        if(originCount == exceptionCount) {
        	isContain = false;
        }
        br.close();
        return isContain;
	}
	
	private boolean checkContainsKeyword(BufferedReader br, String keyword) throws IOException{
		String line;
        while(true) {
            line = br.readLine();
            if (line==null) break;
            if(line.contains(keyword)) {
            	return true;
            }
        }
        br.close();
        return false;
	}

	public static void main(String[] args) throws IOException{
		
		CheckJsp s = new CheckJsp();
		BufferedReader br = new BufferedReader(new FileReader("C:/Users//Desktop/textMemo/all_input_jsp.txt"));
		List<String> list = new ArrayList<>();
		s.scanAllJsp(br, list);
	}
}
