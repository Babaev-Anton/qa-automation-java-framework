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

public class HardLoginTest {

    private WebDriver driver;

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

    @Test
    void testHardLoginTest(){
        WebElement username = driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input"));
        WebElement password = driver.findElement(By.xpath("//label[text()='Password']/following-sibling::input"));
        WebElement login = driver.findElement(By.xpath("//form[@id='login']/child::button"));
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        login.click();
        WebElement flashMessage = driver.findElement(By.xpath("//*[contains(text(), 'logged')]"));
        String message = flashMessage.getText();
        assertTrue(message.contains("You logged into a secure area!"));
        WebElement logout = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i"));
        logout.click();
        WebElement loginPage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2"));
        String secondMessage = loginPage.getText();
        assertTrue(secondMessage.contains("Login Page"));
    }
}
