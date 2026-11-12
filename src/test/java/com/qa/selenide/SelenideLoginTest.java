package com.qa.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SelenideLoginTest {

    @BeforeAll
    static void setUp(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void loginTest(){
        open("/login");

        $("#username").setValue("tomsmith");
        $("#password").setValue("SuperSecretPassword!");
        $("button[type='submit']").click();

        $("#flash").shouldHave(text("You logged into a secure area"));
        $("a[href='/logout']").shouldBe(visible);
    }
}
