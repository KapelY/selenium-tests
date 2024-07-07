package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {

    @Test
    public void incorrectUserNameTest() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("incorrect");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("#flash"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");

        errorMessage = driver.findElement(By.xpath("//div[@id='flash']"));
        Assert.assertTrue(errorMessage.getText().contains("Your username is invalid!"), "Message is not as expected");

        driver.quit();
    }

    @Test
    public void incorrectPasswordTest() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("incorrect");

        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("#flash"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");

        errorMessage = driver.findElement(By.xpath("//div[@id='flash']"));
        Assert.assertTrue(errorMessage.getText().contains("Your password is invalid!"), "Message is not as expected");

        driver.quit();
    }
}
