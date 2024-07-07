package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExceptionsTests {
    private WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        driver.manage().window().maximize();
    }

    @Test
    public void homeworkTest() {

        WebElement addButtonElement = driver.findElement(By.id("add_btn"));
        addButtonElement.click();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement row2Input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));

        Assert.assertTrue(row2Input.isDisplayed(), "row2 input is not displayed");
        row2Input.sendKeys("");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
