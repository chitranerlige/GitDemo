package payloads.builder;

import java.util.Arrays;

import payloads.request.AddPlaceRequest;
import payloads.request.AddPlaceLocation;

public class AddPlaceBuilder {

	
    public static AddPlaceRequest build() {

        AddPlaceRequest request = new AddPlaceRequest();

        AddPlaceLocation location = new AddPlaceLocation();

        location.setLat(-38.383494);
        location.setLng(33.427362);

        request.setLocation(location);

        request.setAccuracy(50);
        request.setName("Frontline house");
        request.setPhone_number("(+91)9838933937");
        request.setAddress("29, side layout, cohen 09");
        request.setTypes(Arrays.asList("shoe park","shop"));
        request.setWebsite("http://google.com");
        request.setLanguage("French-IN");

        return request;

    }

}