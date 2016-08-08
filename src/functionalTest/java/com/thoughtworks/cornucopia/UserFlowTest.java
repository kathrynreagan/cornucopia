package com.thoughtworks.cornucopia;

import com.thoughtworks.cornucopia.api.ScreenApi;
import com.thoughtworks.cornucopia.api.UserApi;
import org.junit.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UserFlowTest extends FunctionalTestBase {

    @Test
    public void userFlow() {

        user
                .goToHomePage();
        screen
                .shouldShowHomePage()
                .shouldShowTextBox()
                .shouldShowSubmitButton();

        user
                .clickSubmitIngredientsButton();

        screen
                .shouldShowHomePage();

        user
                .inputIngredientsInTextBox("New York, Dallas, San Francisco")
                .clickSubmitIngredientsButton();

        screen
                .shouldShowResultsPage()
                .shouldShowRecipesNotFoundMessage();


        user
                .clicksTryAgainButton();
        screen
                .shouldShowHomePage();

        user
                .inputIngredientsInTextBox("Pasta, Cheese, Tomato")
                .clickSubmitIngredientsButton();

        screen
                .shouldShowResultsPage()
                .shouldShowRecipes(new String[]{"The Best Lasagna Ever", "Pasta Alla Vodka", "Bacon Ranch Pasta Salad"});



    }
}
