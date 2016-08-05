package com.thoughtworks.cornucopia.api;

import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


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
}
