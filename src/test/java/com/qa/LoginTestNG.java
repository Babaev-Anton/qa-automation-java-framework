package com.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.qa.config.ConfigManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPageV3;
import pages.SecureAreaPageV3;
import static org.testng.Assert.assertTrue;

public class LoginTestNG {
    private static final Logger logger = LogManager.getLogger(LoginTestNG.class);

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
        Configuration.browser = ConfigManager.getBrowser();
        Configuration.baseUrl = ConfigManager.getBaseUrl();
        Configuration.timeout = ConfigManager.getTimeout();
    }

    @Test
    public void successLoginTest() {
        logger.info("Начинаем тест логина");
        LoginPageV3 loginPageV3 = new LoginPageV3();
        SecureAreaPageV3 secureAreaPageV3 = loginPageV3
                .openPage()
                .login("tomsmith", "SuperSecretPassword!")
                .getFlashMessage();
        LoginPageV3 againLoginPageV3 = secureAreaPageV3.logoutButtonClick();
        assertTrue(againLoginPageV3.isLoginPageOpenAgain());
        logger.info("Тест завершён успешно");
    }

    @Test
    public void secondLoginTest() {
        logger.info("Начинаем второй тест логина");
        LoginPageV3 loginPageV3 = new LoginPageV3();
        SecureAreaPageV3 secureAreaPageV3 = loginPageV3
                .openPage()
                .login("tomsmith", "SuperSecretPassword!")
                .getFlashMessage();
        assertTrue(secureAreaPageV3.isLogoutButtonDisplayed());
        logger.info("Второй тест завершён");
    }
}
