package com.qa.pageObject;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.DropdownPage;
import static org.junit.jupiter.api.Assertions.assertEquals;




public class TestDropdownPageObject {
    @BeforeAll
    static void setUp(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void testDropdown(){
        DropdownPage dropdownPage = new DropdownPage();
        dropdownPage
                .openPage()
                .selectOption("Option 1");
        assertEquals("Option 1", dropdownPage.getSelectedOption());
        dropdownPage.selectOption("Option 2");
        assertEquals("Option 2", dropdownPage.getSelectedOption());
    }
}
