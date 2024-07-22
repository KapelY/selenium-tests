package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {

    private final WebDriver driver;
    private final Logger log;

    public SecureAreaPage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

}
