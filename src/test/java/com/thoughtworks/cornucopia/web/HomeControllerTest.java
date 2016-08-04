package com.thoughtworks.cornucopia.web;

import com.thoughtworks.cornucopia.HomeController;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import static junit.framework.TestCase.assertEquals;

public class HomeControllerTest {

    @Test
    public void testPrintWelcomeReturnsHome() {
        HomeController homeController = new HomeController();
        ModelMap modelMap = new ModelMap();

        assertEquals("home", homeController.printWelcome(modelMap));
     }
}
