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
		FindStringByWildCard s = new FindStringByWildCard();
		String pattern = "<iframe";
        while(true) {
            line = br.readLine();
            if (line==null) break;
            BufferedReader fileBr;
            boolean isContains = false;
            try {
            	fileBr = new BufferedReader(new FileReader(header+line));
            	isContains = checkContainsKeyword(fileBr, pattern);
			} catch (IOException e) {
				continue;
			}
            if(isContains) {
            	System.out.println(line);
//            	list.add(line);
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
	
	private boolean findByPattern(BufferedReader br, String pattern, FindStringByWildCard s) throws IOException{
		String line;
        while(true) {
            line = br.readLine();
            if (line==null) break;
            if(s.isMatch(line, pattern)) {
            	return true;
            }
        }
        br.close();
        return false;
	}

	public static void main(String[] args) throws IOException{
		
		CheckJsp s = new CheckJsp();
		BufferedReader br = new BufferedReader(new FileReader("C:/Users//Desktop/textMemo/todo_jsp.txt"));
		List<String> list = new ArrayList<>();
		s.scanAllJsp(br, list);
		
	}
}
