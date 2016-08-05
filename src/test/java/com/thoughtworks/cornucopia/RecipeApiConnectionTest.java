package com.thoughtworks.cornucopia;

import org.junit.Ignore;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class RecipeApiConnectionTest {

    /*
    * This test actually calls the API and ensures we're getting a valid response.
    * Ignored so that our tests are only testing our code, and not the API.
    * */

    @Ignore @Test
    public void shouldReturnResponseWhenValidApiRequestIsSent() throws MalformedURLException {
        RecipeApiConnection recipeApiConnection = new RecipeApiConnection();
        URL url = new URL("http://food2fork.com/api/search?key=d58c01859288708b43b44fb004c81c45&q=chicken,zucchini");

        assertTrue(recipeApiConnection.retrieveResponse(url).contains("chicken"));
    }

}
