package com.qa.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;


public class SelenideAddRemoveTest {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void selenideAddRemoveElementsTest() {
        open("/add_remove_elements/");
        $("button").click();
        $("button").click();
        $("button").click();

        $$(".added-manually").shouldHave(size(3));
        $$(".added-manually").get(0).click();
        $$(".added-manually").shouldHave(size(2));


    }
}