package client;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import payloads.builder.AddPlaceBuilder;
import payloads.response.AddPlaceResponse;

import specifications.RequestSpecFactory;
import specifications.ResponseSpecFactory;

import endpoints.EndPoints;

public class PlaceApiClient {

    public static Response addPlace(){

        return RestAssured

                .given()

                .spec(RequestSpecFactory.getRequestSpec())

                .body(AddPlaceBuilder.build())

                .when()

                .post(EndPoints.ADD_PLACE)

                .then()

                .spec(ResponseSpecFactory.successResponse())

                .extract()

                .response();

    }

    public static AddPlaceResponse addPlaceAsObject(){

        return addPlace().as(AddPlaceResponse.class);

    }
}