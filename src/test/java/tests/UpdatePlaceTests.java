package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import client.PlaceApiClient;
import client.UpdateApiClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.JsonObject;
import utils.TestData;

@Test(dataProvider = "excelData", dataProviderClass = TestData.class)
public class UpdatePlaceTests extends BaseTest {
	@Test

	public void verifyUpdatePlace(String address, String key) {

		String placeId = PlaceApiClient.addPlaceAsObject().getPlace_id();

		Response response = UpdateApiClient.updatePlace(placeId, address, key);

		JsonPath js = JsonObject.jsonPathObject(response);
		String message = js.get("msg");
		System.out.println(message);

		Assert.assertEquals(message, "Address successfully updated");

	}
}
