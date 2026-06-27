package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import client.GetApiClient;
import client.PlaceApiClient;
import payloads.response.GetPlaceResponse;

@Listeners(listeners.TestListeners.class)
public class GetPlaceTests extends BaseTest {

	@Test

	public void verifyGetPlace() {

		String placeId = PlaceApiClient.addPlaceAsObject().getPlace_id();

		GetPlaceResponse response = GetApiClient.getPlaceAsObject(placeId);

		Assert.assertEquals(response.getName(), "Frontline house");

	}

}
