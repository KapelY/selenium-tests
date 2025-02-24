package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final WebDriver driver;
    private final Logger log;

    private final By usernameLocator = By.id("username");
    private final By passwordLocator = By.name("password");
    private final By logInButtonLocator = By.tagName("button");

    public LoginPage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    /** Execute log in */
    public SecureAreaPage logIn(String username, String password) {
        log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(logInButtonLocator).click();
        return new SecureAreaPage(driver, log);
    }

}
