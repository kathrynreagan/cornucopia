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
        System.out.println("************" + jsonRepresentationOfRecipe);

        Recipe recipe = gson.fromJson(jsonRepresentationOfRecipe, Recipe.class);

        return recipe;
    }

    public List<Recipe> parseRecipeResultsList(String listOfJsonRecipes) {
        int startBracketIndex = listOfJsonRecipes.indexOf("[");
        listOfJsonRecipes = listOfJsonRecipes.substring(startBracketIndex + 1);
        String[] recipes = listOfJsonRecipes.split("\\{");

        List<Recipe> recipesList = new ArrayList<>();

        for(int i = 1; i < recipes.length; i++) {
            int endCurlyBraceIndex = recipes[i].indexOf("}");
            recipesList.add(parseRecipe("{" + recipes[i].substring(0, endCurlyBraceIndex + 1)));
        }

        return recipesList;
    }
}
