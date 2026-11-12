package com.qa.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class SelenideCheckboxesTest {

    @BeforeAll
    static void setUp(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void CheckboxesTest(){
        open("/checkboxes");

        $$("input[type='checkbox']").get(0).shouldNotBe(checked);
        $$("input[type='checkbox']").get(1).shouldBe(checked);

        $$("input[type='checkbox']").get(0).click();
        $$("input[type='checkbox']").get(1).click();

        $$("input[type='checkbox']").get(0).shouldBe(checked);
        $$("input[type='checkbox']").get(1).shouldNotBe(checked);
    }
}
