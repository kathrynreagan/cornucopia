package com.thoughtworks.cornucopia.api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class ScreenApi {

    public static final String BASE = "http://localhost:8080";
    private WebDriver driver;

    public ScreenApi(WebDriver driver) {
        this.driver = driver;
    }

    public ScreenApi shouldShowHomePage() {
        assertThat(driver.getCurrentUrl(), is(BASE + "/"));
        return this;
    }

    public ScreenApi shouldShowTextBox() {
        assertTrue(driver.findElement(By.id("ingredients_input")).isDisplayed());
        return this;
    }

    public ScreenApi shouldShowSubmitButton() {
        assertTrue(driver.findElement(By.id("ingredients_submit")).isDisplayed());
        return this;
    }

    public ScreenApi shouldShowResultsPage() {
        assertThat(driver.getCurrentUrl(), is(BASE + "/results"));
        return this;
    }

    public ScreenApi shouldShowIngredientsWarning() {
        assertTrue(driver.findElement(By.id("ingredients_warning")).isDisplayed());
        return this;
    }

    public ScreenApi shouldShowRecipes(String[] recipeTitles) {
        String recipeText = driver.findElement(By.id("recipe_list")).getText();
        for( int i = 0; i < recipeTitles.length; i ++){
            assertThat(recipeText, containsString(recipeTitles[i]));
        }
        return this;
    }

    public ScreenApi shouldShowRecipesNotFoundMessage(String enteredIngredients) {
        String recipeNotFoundMessage = driver.findElement(By.id("recipes_not_found")).getText();
        assertThat(recipeNotFoundMessage, containsString("Sorry, no recipes were found with: " + enteredIngredients));
        return this;

    }
}
