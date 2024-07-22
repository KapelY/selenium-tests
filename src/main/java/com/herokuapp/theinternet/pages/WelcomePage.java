package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage {
    private final WebDriver driver;
    private final Logger log;
    private final By formAuthenticationLinkLocator = By.linkText("Form Authentication");

    public WelcomePage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    public void openPage() {
        driver.get("http://the-internet.herokuapp.com/");
        log.info("Welcome page opened");
    }

    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking Form Authentication link on Welcome Page");
        driver.findElement(formAuthenticationLinkLocator).click();
        return new LoginPage(driver, log);
    }
}
