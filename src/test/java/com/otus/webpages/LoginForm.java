package com.otus.webpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginForm extends BasePage{
    public LoginForm(WebDriver driver) {
        super(driver);
    }

    private static final Logger LOGGER = LogManager.getLogger(LoginForm.class);

    private By emailField = By.cssSelector("form[action='/login/'] input[name='email']");
    private By passwordField = By.cssSelector("form[action='/login/'] input[name='password']");
    private By loginButton = By.cssSelector("form[action='/login/'] button");

    public HomePage loginWithValidCredentials(String mail, String pwd){
        driver.findElement(emailField).sendKeys(mail);
        driver.findElement(passwordField).sendKeys(pwd);
        driver.findElement(loginButton).click();
        LOGGER.info("Logging in with credentials: {}/{}", mail, pwd);
        return new HomePage(driver);
    }

}
