package abhi.base.util;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class JsonUtil {
	
	/****
	 * JsonArray
	 */
	public static JsonArray convertToJsonArray(String jsonStr){
	JsonReader reader = Json.createReader(new StringReader(jsonStr));
	JsonArray jsonArray = reader.readArray();
	reader.close();
	return jsonArray;
	}
	
	
	/***
	 * Returns JsonObject
	 * @param jsonStr
	 * @return
	 */
	public static JsonObject convertToJsonObject(String jsonStr){
	
		
		JsonReader reader = Json.createReader(new StringReader(jsonStr));
		JsonObject json = reader.readObject();
		reader.close();
		return json;
		}
	

}
