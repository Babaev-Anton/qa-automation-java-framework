package com.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.EntryAdPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.codeborne.selenide.Selenide.*;

public class EntryAdPageTest {

    @BeforeAll
    static void setUp(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void testModalWindowVisible(){
        EntryAdPage entryAdPage = new EntryAdPage();
        entryAdPage.openPage();
        assertEquals("THIS IS A MODAL WINDOW", entryAdPage.getModalWindowHeadertext());
        assertEquals("It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something or disable their ad blocker).", entryAdPage.getModelWindowBodyText());
    }
    @Test
    void testModalWindowClose(){
        EntryAdPage entryAdPage = new EntryAdPage();
        entryAdPage
                .openPage()
                .closeModalWindow();
    }
}
