package abhi.base.fw;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonStructure;

import abhi.base.util.JsonUtil;

public interface JsonBeanConverter {
	
	
	public <T> T returnBean(JsonObject json, T bean, Integer index);
	public <T> T returnBean(JsonArray json, T bean);
	public <T> void process(T bean);

	default <T> JsonStructure returnJsonObject(String jsonStr, T bean){
		JsonStructure  object =null;
		try{
		 object = JsonUtil.convertToJsonObject(jsonStr);
		}catch(Exception e){
			object = JsonUtil.convertToJsonArray(jsonStr);
		}
		return object;
		
	}
}
