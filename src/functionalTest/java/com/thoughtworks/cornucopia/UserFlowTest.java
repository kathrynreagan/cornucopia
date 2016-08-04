package com.thoughtworks.cornucopia;

import com.thoughtworks.cornucopia.api.ScreenApi;
import com.thoughtworks.cornucopia.api.UserApi;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UserFlowTest {

    private WebDriver driver;
    private UserApi user;
    private ScreenApi screen;

    @Before
    public void setUp() throws Exception {

        driver = new FirefoxDriver();
        user = new UserApi(driver);
        screen = new ScreenApi(driver);
    }


    @Test
    public void userFlow() {

        user.goToHomePage();
        screen.shouldShowHomePage();

    }
}
