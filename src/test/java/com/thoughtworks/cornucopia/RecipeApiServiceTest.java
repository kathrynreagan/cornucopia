package com.thoughtworks.cornucopia;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class RecipeApiServiceTest {

    @Mock
    private RecipeApiConnection recipeApiConnection;

    @InjectMocks
    RecipeApiService recipeApiService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldSubmitAGetRequestToFood2ForkApiWhenGivenIngredients() throws IOException {
        when(recipeApiConnection.retrieveResponse(any(URL.class))).thenReturn("Grandma's Apple Pie");

        String apiResponse = recipeApiService.sendRequest("apples,bananas");

        assertTrue(apiResponse.contains("Apple"));
    }

    @Test
    public void shouldCreateRequestUrlWithIngredientsWhenGivenIngredientsWithoutSpaces() throws MalformedURLException {
        String ingredients = "apples,bananas";
        URL expectedUrl = new URL("http://food2fork.com/api/search?key=d58c01859288708b43b44fb004c81c45&q=apples,bananas");
        assertEquals(expectedUrl, recipeApiService.createUrlFromIngredients(ingredients));
    }

    @Test
    public void shouldReplaceSpacesInIngredientsListWithPercent20() {

        String newString = recipeApiService.replaceSpaces("apples, bananas, shredded chicken");

        assertThat(newString, is("apples,%20bananas,%20shredded%20chicken"));

    }

}
