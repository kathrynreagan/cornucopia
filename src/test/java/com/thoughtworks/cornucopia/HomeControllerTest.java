package com.thoughtworks.cornucopia;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;


public class HomeControllerTest {

    @Mock
    RecipeApiService recipeApiService;

    @Mock
    ModelMap modelMap;

    private HomeController homeController;


    @Before
    public void setUp() {
        initMocks(this);
        homeController = new HomeController(recipeApiService);
    }

    @Test
    public void testPrintWelcomeReturnsHome() {
        assertEquals("home", homeController.printWelcome(modelMap));
     }

    @Test
    public void shouldCallRecipeServiceWhenGivenAString() {
        String listOfIngredients = "apples, oranges";

        homeController.sendIngredientsListToRecipeApi(listOfIngredients);

        verify(recipeApiService).sendRequest(listOfIngredients);

    }


}
