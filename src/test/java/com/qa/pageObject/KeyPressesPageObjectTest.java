package com.qa.pageObject;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.KeyPressesPage;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class KeyPressesPageObjectTest {

    @BeforeAll
    static void setUp(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @ParameterizedTest
    @CsvSource({
            "TAB, You entered: TAB",
            "ESCAPE, You entered: ESCAPE",
            "T, You entered: T"
    })
    void keyPressTest (String key, String expected){
        KeyPressesPage keyPressesPage = new KeyPressesPage();
        keyPressesPage
                .openPage()
                .pressKey(key);
        assertEquals(expected,keyPressesPage.getResultText());
    }
}
