package com.qa.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SelenideDynamicLoadingTest {

    @BeforeAll
    static void setUp(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.timeout = 10000;
    }

    @Test
    void selenideDynamicLoadingTest (){
        open("/dynamic_loading/2");
        $("button").click();
        $("#finish").shouldBe(visible).shouldHave(text("Hello World!"));
    }
}
