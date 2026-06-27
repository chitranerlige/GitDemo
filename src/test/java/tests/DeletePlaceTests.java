package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import client.DeleteApiClient;
import client.PlaceApiClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.JsonObject;

@Test
public class DeletePlaceTests extends BaseTest {
	@Test

	public void verifyDeletePlace() {

		String placeId = PlaceApiClient.addPlaceAsObject().getPlace_id();

		Response response = DeleteApiClient.deletePlace(placeId);

		JsonPath js = JsonObject.jsonPathObject(response);
		String status = js.get("status");
		System.out.println(status);

		Assert.assertEquals(status, "OK");

	}
}
