package com.thoughtworks.cornucopia;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;

import java.net.MalformedURLException;

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

    @InjectMocks
    private HomeController homeController;


    @Before
    public void setUp() {
        initMocks(this);
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
    public void shouldCallRecipeServiceWhenGivenAString() throws MalformedURLException {
        String ingredients = "apple, oranges";
        when(request.getParameter("ingredients")).thenReturn(ingredients);

        homeController.sendIngredientsListToRecipeApi(request);

        verify(recipeApiService).sendRequest(ingredients);

    }


}
