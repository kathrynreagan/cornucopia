package com.thoughtworks.cornucopia;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JsonParser {
    public Recipe parseRecipe(String jsonRepresentationOfRecipe) {

        if(jsonRepresentationOfRecipe.equals("")){
            return new Recipe(null,null);
        }

        Gson gson = new Gson();

        Recipe recipe = gson.fromJson(jsonRepresentationOfRecipe, Recipe.class);

        return recipe;
    }

    public List<Recipe> parseRecipeResultsList(String listOfJsonRecipes) {
        int bracketIndex = listOfJsonRecipes.indexOf("[");
        listOfJsonRecipes = listOfJsonRecipes.substring(bracketIndex + 1);
        String[] recipes = listOfJsonRecipes.split("\\{");

        List<Recipe> recipesList = new ArrayList<>();

        for(int i = 1; i < recipes.length; i++) {
            recipesList.add(parseRecipe("{" + recipes[i].substring(0, (recipes[i].length())-2)));
        }

        return recipesList;
    }
}
