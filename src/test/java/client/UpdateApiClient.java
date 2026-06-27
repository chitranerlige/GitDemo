package client;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import payloads.builder.UpdatePlaceBuilder;

import specifications.RequestSpecFactory;
import specifications.ResponseSpecFactory;
import endpoints.EndPoints;

public class UpdateApiClient {

    public static Response updatePlace(String placeId,String address,String key){

        return RestAssured

                .given()

                .spec(RequestSpecFactory.getRequestSpec())

                .body(UpdatePlaceBuilder.build(placeId,address,key))

                .when()

                .put(EndPoints.UPDATE_PLACE)

                .then()

                .spec(ResponseSpecFactory.successResponse())

                .extract()

                .response();

    }
}