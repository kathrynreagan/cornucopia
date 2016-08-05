package com.thoughtworks.cornucopia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class RecipeApiService {

    private RecipeApiConnection recipeApiConnection;

    @Autowired
    public RecipeApiService(RecipeApiConnection recipeApiConnection) {
        this.recipeApiConnection = recipeApiConnection;
    }


    public String sendRequest(String ingredients) throws MalformedURLException {

        URL apiRequestUrl = createUrlFromIngredients(ingredients);
        String result = recipeApiConnection.retrieveResponse(apiRequestUrl);

        return result;

    }

    public URL createUrlFromIngredients(String ingredients) throws MalformedURLException {
        String baseUrlText = "http://food2fork.com/api/search?key=d58c01859288708b43b44fb004c81c45&q=";

        return new URL(baseUrlText+ingredients);
    }

}
