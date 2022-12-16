package openAPI;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.google.gson.Gson;

public class SpeechToText {
	
	private final String openApiURL = "http://aiopen.etri.re.kr:8000/WiseASR/Recognition";
	private String accessKey;    // 발급받은 API Key
	
	public SpeechToText(String path) {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(path));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		accessKey = properties.getProperty("api_key");
	}
	
	public void printSpeech(String languageCode, String audioFilePath) {
		String audioContents = null;
		 
        Gson gson = new Gson();
 
        Map<String, Object> request = new HashMap<>();
        Map<String, String> argument = new HashMap<>();
 
        try {
            Path path = Paths.get(audioFilePath);
            byte[] audioBytes = Files.readAllBytes(path);
            audioContents = Base64.getEncoder().encodeToString(audioBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        argument.put("language_code", languageCode);
        argument.put("audio", audioContents);
 
        request.put("argument", argument);
 
        URL url;
        Integer responseCode = null;
        String responBody = null;
        try {
            url = new URL(openApiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setRequestProperty("Authorization", accessKey);
            
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.write(gson.toJson(request).getBytes("UTF-8"));
            wr.flush();
            wr.close();
            
            responseCode = con.getResponseCode();
            InputStream is = con.getInputStream();
            byte[] buffer = new byte[is.available()];
            int byteRead = is.read(buffer);
            responBody = new String(buffer);
 
            System.out.println("[responseCode] " + responseCode);
            System.out.println("[responBody]");
            System.out.println("읽은 byte read count : " + byteRead);
            int objectIndex = responBody.indexOf("recognized");
            String value = responBody.substring(objectIndex+13).replaceAll("\\}|\"", "");
            System.out.println(value);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}
