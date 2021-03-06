package com.thoughtworks.cornucopia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {

    private final RecipeApiService recipeApiService;
    private JsonParser jsonParser;

    @Autowired
    public HomeController(RecipeApiService recipeApiService, JsonParser jsonParser) {
        this.recipeApiService = recipeApiService;
        this.jsonParser = jsonParser;
    }

    @RequestMapping( method = RequestMethod.GET)
    public String getHomePage(ModelMap model) {
        return "home";
    }

    @RequestMapping(value = {"/results"}, method = RequestMethod.POST)
    public ModelAndView sendIngredientsListToRecipeApi(HttpServletRequest request) throws MalformedURLException {
        ModelMap model = new ModelMap();

        String ingredients = request.getParameter("ingredients");

        model.put("enteredIngredients", ingredients);

        if(ingredients.equals("")){
            return new ModelAndView("redirect:/");
        }

        String recipesJson = recipeApiService.sendRequest(ingredients);

        List<Recipe> recipes = jsonParser.parseRecipeResultsList(recipesJson);

        if(recipes.isEmpty()){
            model.put("isRecipeListEmpty", true);
        } else {
            model.put("isRecipeListEmpty", false);
        }

        model.put("recipeList", recipes);



        return new ModelAndView("results", model);
    }

    @RequestMapping(value = {"/results"}, method = RequestMethod.GET)
    public String getRecipes(ModelMap modelMap) {
        return "results";
    }
}