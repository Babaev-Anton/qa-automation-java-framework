package com.qa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class CheckboxesTest {
    private WebDriver driver;

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

    @Test
    void checkBoxesTest(){
        WebElement firstElement = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement secondElement = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        assertFalse(firstElement.isSelected());
        assertTrue(secondElement.isSelected());
        firstElement.click();
        assertTrue(firstElement.isSelected());
        secondElement.click();
        assertFalse(secondElement.isSelected());
    }
}
