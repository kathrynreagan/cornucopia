package com.thoughtworks.cornucopia.api;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;


public class ScreenApi {

    public static final String BASE = "http://localhost:8080";
    private WebDriver driver;

    public ScreenApi(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public ScreenApi shouldShowHomePage() {
        assertEquals(BASE + "/", driver.getCurrentUrl());
        return this;
    }
}
