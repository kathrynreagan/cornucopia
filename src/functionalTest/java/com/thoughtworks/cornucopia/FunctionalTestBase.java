package com.thoughtworks.cornucopia;

import com.thoughtworks.cornucopia.api.ScreenApi;
import com.thoughtworks.cornucopia.api.UserApi;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FunctionalTestBase {

    private static WebDriver driver;

    protected static UserApi user;
    protected static ScreenApi screen;

    @BeforeClass
    public static void before() {
        driver = new FirefoxDriver();

        user = new UserApi(driver);
        screen = new ScreenApi(driver);

        driver.manage().window().setSize(new Dimension(1400, 600));
    }

    @AfterClass
    public static void after() {
        driver.quit();
    }
}
