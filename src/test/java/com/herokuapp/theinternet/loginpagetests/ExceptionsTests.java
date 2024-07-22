package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExceptionsTests extends TestUtilities {

    @Test
    public void homeworkTest() {

        WebElement addButtonElement = driver.findElement(By.id("add_btn"));
        addButtonElement.click();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement row2Input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));

        Assert.assertTrue(row2Input.isDisplayed(), "row2 input is not displayed");
    }

    @Test
    public void elementNotInteractableExceptionTest() {

        WebElement addButtonElement = driver.findElement(By.id("add_btn"));
        addButtonElement.click();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement row2Input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));

        row2Input.sendKeys("Sushi");

        WebElement save = driver.findElement(By.xpath("//div[@id='row2']/button[@name='Save']"));
        save.click();

        WebElement confirmation = driver.findElement(By.id("confirmation"));
        Assert.assertEquals(confirmation.getText(), "Row 2 was saved", "confirmation is not as expected");
    }
}
