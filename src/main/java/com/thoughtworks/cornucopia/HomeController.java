package com.thoughtworks.cornucopia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class HomeController {

    private final RecipeApiService recipeApiService;


    @Autowired
    public HomeController(RecipeApiService recipeApiService) {
        this.recipeApiService = recipeApiService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "home";
    }


    @RequestMapping(method = RequestMethod.POST)
    public void sendIngredientsListToRecipeApi(@ModelAttribute("ingredients") String ingredients) {
        recipeApiService.sendRequest(ingredients);
    }
}
