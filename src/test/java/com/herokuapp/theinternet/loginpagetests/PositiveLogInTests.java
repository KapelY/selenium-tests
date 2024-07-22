package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLogInTests extends BaseTest {

    @Test
    public void loginTest() {

        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Url is not as expected");

        WebElement logoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button is not displayed");

        WebElement successMessage = driver.findElement(By.cssSelector("#flash"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed");

        successMessage = driver.findElement(By.xpath("//div[@id='flash']"));
        Assert.assertTrue(successMessage.getText().contains("You logged into a secure area!"), "Message is not as expected");

        driver.quit();
    }
}
