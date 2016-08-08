package com.thoughtworks.cornucopia;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.net.MalformedURLException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
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

    @Mock
    JsonParser jsonParser;

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

    @Test
    public void shouldReturnResultsPageWhenThereAreIngredients() throws MalformedURLException {
        String ingredients = "apple, oranges";
        when(request.getParameter("ingredients")).thenReturn(ingredients);

        ModelAndView modelAndView = homeController.sendIngredientsListToRecipeApi(request);

        assertEquals("results", modelAndView.getViewName());
    }

    @Test
    public void shouldReturnHomePageWhenThereAreNoIngredients() throws MalformedURLException {
        when(request.getParameter("ingredients")).thenReturn("");

        ModelAndView modelAndView = homeController.sendIngredientsListToRecipeApi(request);


        assertEquals("redirect:/", modelAndView.getViewName());
    }

    @Test
    public void shouldReturnModelAndViewWhenGivenValidIngredients() throws MalformedURLException {
        String ingredients = "apple, oranges";
        when(request.getParameter("ingredients")).thenReturn(ingredients);
        when(recipeApiService.sendRequest(ingredients)).thenReturn(null);
        when(jsonParser.parseRecipeResultsList(anyString())).thenReturn(new ArrayList<Recipe>());

        ModelAndView modelAndView = homeController.sendIngredientsListToRecipeApi(request);

        assertTrue(modelAndView.getModelMap().containsAttribute("isRecipeListEmpty"));
        assertTrue(modelAndView.getModelMap().containsAttribute("recipeList"));
    }

}
