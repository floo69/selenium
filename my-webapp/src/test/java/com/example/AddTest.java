package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();  // Auto matches Chrome 145
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///C:\\Users\\admin\\my-webapp\\src\\main\\webapp\\index.html");
    }

    @Test
    public void testAddition() throws InterruptedException {

        WebElement num1 = driver.findElement(By.id("num1"));
        WebElement num2 = driver.findElement(By.id("num2"));
        WebElement button = driver.findElement(By.tagName("button"));

        num1.sendKeys("10");
        num2.sendKeys("20");
        button.click();

        Thread.sleep(1000);

        WebElement result = driver.findElement(By.id("result"));
        String actualResult = result.getText();

        Assert.assertTrue(actualResult.contains("30"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}