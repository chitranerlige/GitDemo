package specifications;


import constants.ApiConstants;
import filters.ApiLoggingFilter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

public class RequestSpecFactory {
	

    private RequestSpecFactory() {}

    public static RequestSpecification getRequestSpec() {

        return new RequestSpecBuilder()

                .setBaseUri(ConfigReader.getProperty("BASE_URL"))

                .setContentType(ContentType.JSON)

                .addQueryParam("key", ApiConstants.API_KEY)

                .setRelaxedHTTPSValidation()
                
                .addFilter(new ApiLoggingFilter())

                .build();

    }

}