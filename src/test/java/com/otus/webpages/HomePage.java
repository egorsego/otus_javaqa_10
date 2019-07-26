package com.otus.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    private static final String URL = "https://otus.ru/";
    private By loginRegistrationButton = By.xpath("//button[@data-modal-id='new-log-reg']");
    private By accountIcon = By.cssSelector("div.header2-menu__icon div.ic-blog-default-avatar");
    private By profileLink = By.xpath("//a[contains(@href, 'personal')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open(){
        driver.get(URL);
        return this;
    }

    public LoginForm openLoginForm(){
        driver.findElement(loginRegistrationButton).click();
        return new LoginForm(driver);
    }

    public UserProfilePage openUserProfile(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(accountIcon)).perform();
        driver.findElement(profileLink).click();
        return new UserProfilePage(driver);
    }
}
