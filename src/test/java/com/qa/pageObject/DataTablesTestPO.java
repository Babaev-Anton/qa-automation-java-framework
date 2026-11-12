package com.qa.pageObject;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.qa.config.ConfigManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import pages.DataTablesPage;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DataTablesTestPO {

    @BeforeAll
    static void setUp(){
        Configuration.browser = ConfigManager.getBrowser();
        Configuration.baseUrl = ConfigManager.getBaseUrl();
        Configuration.timeout = ConfigManager.getTimeout();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @Test
    void testFindDueByLastName(){
        DataTablesPage dataTables = new DataTablesPage();
        String due = dataTables
                .openPage()
                .getDueByLastName("Smith");
        assertEquals("$50.00", due);
    }

    @Test
    void testFindEmailByFirstName(){
        String email = new DataTablesPage()
                .openPage()
                .getEmailByFirstName("Jason");
        assertEquals("jdoe@hotmail.com", email);
    }

    @Test
    void testSortedByDue(){
        DataTablesPage dataTables = new DataTablesPage();
        dataTables.
                openPage()
                .sortedByDue();
        String firstRow = dataTables.getFirstRowDue();
        String lastRow = dataTables.getLastRowDue();
        assertEquals("$50.00", firstRow);
        assertEquals("$100.00", lastRow);
    }

    @Test
    void testFindWebsiteByLastName(){
        DataTablesPage dataTablesPage = new DataTablesPage();
        dataTablesPage.openPage();
        assertEquals("http://www.frank.com", dataTablesPage.getWebSiteByLastName("Bach"));
    }

    @Test
    void testFindDueByFirstName(){
        DataTablesPage dataTablesPage = new DataTablesPage();
        dataTablesPage.openPage();
        assertEquals("$50.00", dataTablesPage.getDueByFirstName("Tim"));
    }

    @Test
    void testGetRowCount(){
        DataTablesPage dataTablesPage = new DataTablesPage();
        dataTablesPage.openPage();
        assertEquals(4, dataTablesPage.getRowCount());
    }

    @Test
    void testGetHeadersCount(){
        DataTablesPage dataTablesPage = new DataTablesPage();
        dataTablesPage
                .openPage()
                .getHeadersCount();
    }

    @Test
    void testSortedByEmail(){
        DataTablesPage dataTablesPage = new DataTablesPage();
        dataTablesPage
                .openPage()
                .sortedByEmail();
    }

    @Test
    void testSortByLastNameAscending(){
        DataTablesPage dataTablesPage = new DataTablesPage();
        dataTablesPage
                .openPage()
                .sortedByLastName();
        assertEquals("Bach", dataTablesPage.getFirstRowLastName());
        assertEquals("Smith", dataTablesPage.getLastRowLastName());
    }

    @Test
    void testTableStructure() {
        DataTablesPage dataTablesPage = new DataTablesPage();
        dataTablesPage.openPage();

        assertEquals(6, dataTablesPage.getHeadersCount());
        assertEquals(4, dataTablesPage.getRowCount());

        // Проверить, что ВСЕ 4 строки имеют кнопки Edit и Delete
        for (int i = 0; i < 4; i++) {
            assertTrue(dataTablesPage.rowsHasButtonEdit(i), "Строка " + i + " не имеет кнопки Edit");
            assertTrue(dataTablesPage.rowsHasButtonDelete(i), "Строка " + i + " не имеет кнопки Delete");
        }
    }
}
