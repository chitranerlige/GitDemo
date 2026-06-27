package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import client.PlaceApiClient;

import payloads.response.AddPlaceResponse;

@Listeners(listeners.TestListeners.class)
public class AddPlaceTests extends BaseTest {

    @Test

    public void verifyAddPlace(){

        AddPlaceResponse response =
                PlaceApiClient.addPlaceAsObject();

        Assert.assertEquals(response.getStatus(),"OK");

    }

}