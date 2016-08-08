package com.thoughtworks.cornucopia;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JsonParserTest {

    private String oneJsonRecipe = "{\"publisher\": \"Closet Cooking\", \"f2f_url\": \"http://food2fork.com/view/35217\", \"title\": \"Chicken, Roasted Butternut Squash and Feta Lasagna\", \"source_url\": \"http://www.closetcooking.com/2010/03/chicken-roasted-butternut-squash-and.html\", \"recipe_id\": \"35217\", \"image_url\": \"http://static.food2fork.com/Chicken,RoastedButternutSquashandFetaLasagna1500d1b9c88a.jpg\", \"social_rank\": 47.90942981848818, \"publisher_url\": \"http://closetcooking.com\"}";

    private String listOfJsonRecipes = "{\"count\": 3, \"recipes\": [{\"publisher\": \"Closet Cooking\", \"f2f_url\": \"http://food2fork.com/view/35203\", \"title\": \"Chicken Enchilada Stuffed Zucchini\", \"source_url\": \"http://www.closetcooking.com/2012/09/chicken-enchilada-stuffed-zucchini.html\", \"recipe_id\": \"35203\", \"image_url\": \"http://static.food2fork.com/Chicken2BEnchilada2BStuffed2BZucchini2B5002B02136c2f7367.jpg\", \"social_rank\": 99.99969219046973, \"publisher_url\": \"http://closetcooking.com\"}, {\"publisher\": \"Real Simple\", \"f2f_url\": \"http://food2fork.com/view/39801\", \"title\": \"Chicken Quesadilla Pie\", \"source_url\": \"http://www.realsimple.com/food-recipes/browse-all-recipes/quesadilla-pie-10000001587000/index.html\", \"recipe_id\": \"39801\", \"image_url\": \"http://static.food2fork.com/casserole_300d81b7108.jpg\", \"social_rank\": 76.6197875127223, \"publisher_url\": \"http://realsimple.com\"}, {\"publisher\": \"Cookstr\", \"f2f_url\": \"http://food2fork.com/view/dd1981\", \"title\": \"Tuscan Chicken, Zucchini and White Bean Ragout\", \"source_url\": \"http://www.cookstr.com/recipes/tuscan-chicken-zucchini-and-white-bean-ragout\", \"recipe_id\": \"dd1981\", \"image_url\": \"http://static.food2fork.com/recipe238045ad.jpg\", \"social_rank\": 35.51930610169644, \"publisher_url\": \"http://www.cookstr.com\"}]}";

    @Test
    public void shouldReturnEmptyRecipeWhenParsingAnEmptyString() {
        JsonParser jsonParser = new JsonParser();

        Recipe recipe = jsonParser.parseRecipe("");

        assertThat(recipe, is(new Recipe(null, null)));
    }



    @Test
    public void shouldCreateNewRecipeWhenParsingASingleJsonRecipe() {
        JsonParser jsonParser = new JsonParser();

        Recipe recipe = jsonParser.parseRecipe(oneJsonRecipe);

        assertThat(recipe, is(new Recipe("Chicken, Roasted Butternut Squash and Feta Lasagna", "http://www.closetcooking.com/2010/03/chicken-roasted-butternut-squash-and.html")));

    }

}