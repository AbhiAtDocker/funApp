package abhi.base.fw.thirdParty.word.client.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/*

import javax.json.JsonObject;*/

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import abhi.base.beans.OxfordWord;
import abhi.base.fw.thirdParty.word.client.IClient;
import abhi.base.util.StringUtil;



public class OxfordClient implements IClient {

	private final static String API_ID_KEY ="app_id";
	private final static String API_KEY ="app_key";
	private final static String API_ID_VALUE ="0fd1a43d";
	private final static String API_KEY_VALUE ="7e2885c14900f0552bee01819c380681";
	private final static String URL = "https://od-api.oxforddictionaries.com/api/v1";
	private final static String ENTRIES = "entries";
	private final static String LEMMA = "inflections";
	private final static Map<String,String> entries = new HashMap<String,String>();
	private final static Map<String,String> reqParams = new HashMap<>();
	
	static{
		reqParams.put(API_ID_KEY, API_ID_VALUE);
		reqParams.put(API_KEY, API_KEY_VALUE);
		
		entries.put("entries", "entries");
		entries.put("lemma", "inflections");
	    //TODO: write more when needed.  
		
	}
	
	
	public <T> T stringParser(String response) {
	JsonObject obj = null;
	Gson g = new Gson();
	OxfordWord word = g.fromJson(response, OxfordWord.class);

			
	return (T) word;
	}

 
	public static void main(String[] args) {
		
		OxfordClient client = new OxfordClient();
		OxfordWord word = client.processRequest("just", "entries");
		
		
	}
	
	
	
	
    public  String createUrl(String url, String... val1 ){
		final StringBuffer finalUrl = new StringBuffer(url);
		if(url!=null && val1!=null){
		  for(String value:val1) finalUrl.append("/").append(value);
		}
		
	
	  return finalUrl.toString();
	}





	public String createUrl(String url, Map<String, String> qp, String type) {
		// TODO Auto-generated method stub
		return null;
	}





	public String createUrl(String url, Map<String, String> qp, String... vals) {
		// TODO Auto-generated method stub
		return null;
	}




	
	public <T> T processRequest(String word, String entry) {
		String url;
			
		String response  = null;
		OxfordWord oxfordWord = null;
		try{
		 url = createUrl(URL,entry,"en",replaceSpaces(word, "%20"));
		 response = makeRequest(url, reqParams);
		 if(StringUtil.isStringValid(response) && response.startsWith("exception")) 
			 throw new Exception(response);
		 else
		 oxfordWord=  stringParser(response);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return (T) oxfordWord!=null?(T) oxfordWord:null;
	}
	
 public String replaceSpaces(String word, String replaceWith){
	 
	 return word.contains(" ")?word.replace(" ", replaceWith):word;
 }
	
}
