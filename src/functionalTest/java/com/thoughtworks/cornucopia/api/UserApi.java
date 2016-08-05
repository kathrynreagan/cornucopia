package com.thoughtworks.cornucopia.api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.thoughtworks.cornucopia.helpers.Controls.fillField;

public class UserApi {

    public static final String BASE = "http://localhost:8080";
    private WebDriver driver;

    public UserApi(WebDriver driver) {
        this.driver = driver;
    }

    public UserApi goToHomePage() {
        driver.get(BASE + "/");
        return this;
    }

    public UserApi inputIngredientsInTextBox(String ingredients) {
        fillField(driver.findElement(By.id("ingredients_input")), ingredients);
        return this;
    }
}
