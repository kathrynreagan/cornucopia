package com.thoughtworks.cornucopia;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class HomeControllerTest {

    @Mock
    RecipeApiService recipeApiService;

    @Mock
    ModelMap modelMap;

    @Mock
    HttpServletRequest request;

    private HomeController homeController;


    @Before
    public void setUp() {
        initMocks(this);
        homeController = new HomeController(recipeApiService);
    }

    @Test
    public void shouldGetHomePage() {
        assertEquals("home", homeController.getHomePage(modelMap));
     }

    @Test
    public void shouldGetResultsPage() {
        assertEquals("results", homeController.getRecipes(modelMap));
     }


    @Test
    public void shouldCallRecipeServiceWhenGivenAString() {
        String listOfIngredients = "apple, oranges";
        when(request.getParameter("ingredients")).thenReturn(listOfIngredients);

        homeController.sendIngredientsListToRecipeApi(request);

        verify(recipeApiService).sendRequest(listOfIngredients);

    }


}
