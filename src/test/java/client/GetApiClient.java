package client;

import endpoints.EndPoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payloads.response.GetPlaceResponse;
import specifications.RequestSpecFactory;
import specifications.ResponseSpecFactory;

public class GetApiClient {
	public static Response getPlace(String placeId){

        return RestAssured

                .given()

                .spec(RequestSpecFactory.getRequestSpec())
                
                .queryParam("place_id", placeId)

                .when()

                .get(EndPoints.GET_PLACE)

                .then()

                .spec(ResponseSpecFactory.successResponse())

                .extract()

                .response();

    }

    public static GetPlaceResponse getPlaceAsObject(String placeId){

        return getPlace(placeId).as(GetPlaceResponse.class);

    }
}
