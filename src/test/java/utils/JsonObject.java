package utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonObject {

    public static JsonPath jsonPathObject(Response response) {
        return new JsonPath(response.asString());
    }
}
