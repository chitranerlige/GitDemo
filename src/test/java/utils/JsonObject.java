package utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonObject {
	
	public static JsonPath js;
	
	public static JsonPath jsonPathObject(Response response) {
		js = new JsonPath(response.asString());
		return js;
	}
	
	public static String getValue(String key) {
		return js.get(key);
	}
}
