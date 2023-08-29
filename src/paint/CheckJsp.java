package paint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckJsp {
	
	private void scanAllJsp(BufferedReader br, List<String> list) throws IOException{
		String header = "D:/.../.../.../webapp";
		String line;
        while(true) {
            line = br.readLine();
            if (line==null) break;
            if(checkContainsHtml(new BufferedReader(new FileReader(header+line)))) {
            	System.out.println(line);
            }
        }
        br.close();
	}
	
	private boolean checkContainsHtml(BufferedReader br) throws IOException{
		String line;
		boolean isContain = false;
        while(true) {
            line = br.readLine();
            if (line==null) break;
            if(line.contains("<html")) {
            	isContain = true;
            	break;
            }
        }
        br.close();
        return isContain;
	}

	public static void main(String[] args) throws IOException{
		
		CheckJsp s = new CheckJsp();
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/.../Desktop/textMemo/html_lang.txt"));
		List<String> list = new ArrayList<>();
		s.scanAllJsp(br, list);
	}
}
