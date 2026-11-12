package com.qa.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.AddRemovePage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelenideAddRemoveTestWithPageObject {

    @BeforeAll
    static void setUp(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void selenideAddRemoveTestWithPageObject(){
        AddRemovePage addRemovePage = new AddRemovePage();
        addRemovePage.openPage();
        addRemovePage
                .addElement()
                .addElement()
                .addElement();
        assertEquals(3, addRemovePage.getDeleteButtonCount());
        addRemovePage.deleteElement(0);
        assertEquals(2, addRemovePage.getDeleteButtonCount());
    }
}
