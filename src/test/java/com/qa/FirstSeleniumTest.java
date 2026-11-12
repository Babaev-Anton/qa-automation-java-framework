package com.qa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class FirstSeleniumTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

  @AfterEach
    void tearDown(){
        driver.quit();
    }


    @Test
    void testPageTitle() {
        String title = driver.getTitle();
        System.out.println("Заголовок страницы: " + title);
    }

    @Test
    void addRemoveElementsTest() {
        WebElement element = driver.findElement(By.xpath("//button[text()='Add Element']"));
        element.click();
        element.click();
        element.click();

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        assertEquals(3, deleteButtons.size());

        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        List<WebElement> deleteOneButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        assertEquals(2, deleteOneButtons.size());
    }
}

