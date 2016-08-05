package com.thoughtworks.cornucopia;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeApiServiceTest {

    @Test
    public void shouldSubmitGetRequestToFood2ForkApiWhenGivenIngredientsWithoutSpaces() {
        RecipeApiService recipeApiService = new RecipeApiService();

        String result = recipeApiService.sendRequest("apples,bananas");

        System.out.println(result);
        assertNotNull(result);
    }

}
