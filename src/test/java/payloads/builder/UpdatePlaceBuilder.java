package payloads.builder;

import payloads.request.UpdatePlaceRequest;

public class UpdatePlaceBuilder {

	
    public static UpdatePlaceRequest build(String place_id,String address,String key) {

        UpdatePlaceRequest request = new UpdatePlaceRequest();
        request.setPlace_id(place_id);
        request.setAddress(address);
        request.setKey(key);
        return request;

    }

}