package com.qa;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import static org.testng.Assert.assertTrue;

public class TestNGLoginTest {

    @BeforeClass
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    public void testLoginWithTestNG(){
        LoginPage loginPage = new LoginPage();
        loginPage
                .openPage()
                .login("tomsmith", "SuperSecretPassword!")
                .checkLoginSuccess();
    }
}
