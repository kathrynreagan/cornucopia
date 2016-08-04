package com.thoughtworks.cornucopia.api;

import org.openqa.selenium.WebDriver;

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
}
