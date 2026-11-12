package com.qa.pageObject;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.HoversPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoversPageObjectTest {


    @BeforeAll
    static void setUp(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.timeout = 10000;
    }

    @Test
    void testHoversPageObjectTest(){
        HoversPage hoversPage = new HoversPage();
        hoversPage
                .openPage()
                .hoverOnAvatar(0);
        assertEquals("name: user1", hoversPage.getCaptionText(0));
        hoversPage.hoverOnAvatar(1);
        assertEquals("name: user2", hoversPage.getCaptionText(1));
        hoversPage.hoverOnAvatar(2);
        assertEquals("name: user3", hoversPage.getCaptionText(2));
    }
}
