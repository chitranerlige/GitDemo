package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import client.PlaceApiClient;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@Listeners(listeners.TestListeners.class)
public class AddPlaceTests extends BaseTest {

    @Test

    public void verifyAddPlace(){

        Response response =
                PlaceApiClient.addPlace();
        
        response.then()
        .assertThat()
        .body(matchesJsonSchemaInClasspath("schemas/AddPlaceSchema.json"));

    }

}