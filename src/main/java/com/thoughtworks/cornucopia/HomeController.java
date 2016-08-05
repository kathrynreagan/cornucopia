package com.thoughtworks.cornucopia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/")
public class HomeController {

    private final RecipeApiService recipeApiService;


    @Autowired
    public HomeController(RecipeApiService recipeApiService) {
        this.recipeApiService = recipeApiService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getHomePage(ModelMap model) {
        return "home";
    }

    @RequestMapping(value = {"/results"}, method = RequestMethod.POST)
    public void sendIngredientsListToRecipeApi(HttpServletRequest request) {
        String ingredients = request.getParameter("ingredients");
        System.out.println("ingredients " + ingredients);
        recipeApiService.sendRequest(ingredients);
    }

    @RequestMapping(value = {"/results"}, method = RequestMethod.GET)
    public String getRecipes(ModelMap modelMap) {
        return "results";
    }
}
