package abhi.base.fw.thirdParty.word.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;


public interface IClient {

	
	/****
	 * will get the repsonse and return the string
	 * @param url
	 * @return
	 */
	default String makeRequest(String url, Map<String,String> reqParams){
		String response= null;
		if(url!=null){
		  try {
              URL urlObj = new URL(url);
              HttpsURLConnection urlConnection = (HttpsURLConnection) urlObj.openConnection();
              urlConnection.setRequestProperty("Accept","application/json");
              if(reqParams!=null){
            	  reqParams.entrySet().forEach(entry -> urlConnection.setRequestProperty(entry.getKey(),entry.getValue()));
               }
              
              // read the output from the server
              BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
              StringBuilder stringBuilder = new StringBuilder();

              String line = null;
              while ((line = reader.readLine()) != null) {
                  stringBuilder.append(line + "\n");
              }

              return stringBuilder.toString();

          }
          catch (Exception e) {
              e.printStackTrace();
              return "exception: " + e.toString();
          }
		}
		
		return response;
	}
	

	String createUrl(String url, Map<String,String> qp, String type);
	String createUrl(String url, Map<String,String> qp, String...vals);
	<T> T stringParser(String response);
	<T> T processRequest(String word, String entry);
}
