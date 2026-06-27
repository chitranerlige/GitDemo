package client;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import specifications.RequestSpecFactory;
import specifications.ResponseSpecFactory;
import endpoints.EndPoints;

public class DeleteApiClient {

    public static Response deletePlace(String placeId){

        return RestAssured

                .given()

                .spec(RequestSpecFactory.getRequestSpec())

                .body("{ \"place_id\": \"" + placeId + "\" }")

                .when()

                .delete(EndPoints.DELETE_PLACE)

                .then()

                .spec(ResponseSpecFactory.successResponse())

                .extract()

                .response();
    }
}