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
	private String languageCode;
	private String audioFilePath;
	private Integer responseCode = null;
    private String responBody = null;
    private String speechToTextValue = "";
	
	public SpeechToText(String PropertiesPath) {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(PropertiesPath));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		this.accessKey = properties.getProperty("api_key");
	}
	
	public String getText(String languageCode, String audioFilePath) {
		this.languageCode = languageCode;
		this.audioFilePath = audioFilePath;
		
        Map<String, Object> request = new HashMap<>();
        Map<String, String> argument = new HashMap<>();
        
        defaultSetting(request, argument);
        requestAPI(request);
        
        int objectIndex = responBody.indexOf("recognized");
        speechToTextValue = responBody.substring(objectIndex+13).replaceAll("\\}|\"", "");
        System.out.println("response Code : " +responseCode);
        return speechToTextValue;
	}
	
	private void defaultSetting(Map<String, Object> request, Map<String, String> argument) {
		String audioContents = null;
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
	}
	
	private void requestAPI(Map<String, Object> request) {
		Gson gson = new Gson();
		URL url;
		responseCode = null;
        responBody = null;
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
            is.read(buffer);
            responBody = new String(buffer);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}
