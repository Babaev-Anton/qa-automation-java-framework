package com.qa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.*;

public class DynamicLoadingTest {
    private WebDriver driver;

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

    @Test
    void dynamicLoadingTest(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();

        WebElement finishElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        assertEquals("Hello World!", finishElement.getText());

    }
}
