package com.thoughtworks.cornucopia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.MalformedLinkException;
import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;


@Controller
@RequestMapping("/")
public class HomeController {

    private final RecipeApiService recipeApiService;

    @Autowired
    public HomeController(RecipeApiService recipeApiService) {
        this.recipeApiService = recipeApiService;
    }

    @RequestMapping( method = RequestMethod.GET)
    public String getHomePage(ModelMap model) {
        return "home";
    }

    @RequestMapping(value = {"/results"}, method = RequestMethod.POST)
    public String sendIngredientsListToRecipeApi(HttpServletRequest request) throws MalformedURLException {
        String ingredients = request.getParameter("ingredients");

        if(ingredients.equals("")){
            return "redirect:/";
        }

        recipeApiService.sendRequest(ingredients);
        return "results";
    }

    @RequestMapping(value = {"/results"}, method = RequestMethod.GET)
    public String getRecipes(ModelMap modelMap) {
        return "results";
    }
}
