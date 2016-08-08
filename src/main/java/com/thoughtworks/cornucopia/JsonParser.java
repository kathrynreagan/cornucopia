package com.thoughtworks.cornucopia;

import com.google.gson.Gson;

public class JsonParser {
    public Recipe parseRecipe(String jsonRepresentationOfRecipe) {

        if(jsonRepresentationOfRecipe.equals("")){
            return new Recipe(null,null);
        }

        Gson gson = new Gson();

        Recipe recipe = gson.fromJson(jsonRepresentationOfRecipe, Recipe.class);

        return recipe;
    }
}
