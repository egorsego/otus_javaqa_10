package com.otus.tests;

import com.otus.testdata.Contact;
import com.otus.testdata.UserAccount;
import com.otus.testdata.UserAccountBuilder;
import com.otus.webpages.HomePage;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.Arrays;

public class OtusUserProfileTest extends BaseTest {

    @Test
    public void savePersonalInfoTest() {
        UserAccountBuilder userAccountBuilder = new UserAccountBuilder();
        UserAccount originalUser = userAccountBuilder.withFirstName("Эммет")
                                            .withFirstNameLatin("Emmet")
                                            .withLastName("Браун")
                                            .withLastNameLatin("Brown")
                                            .withBlogName("Doc.")
                                            .withBirthDate("20.10.1950")
                                            .livingInCountry("Россия")
                                            .livingInCity("Александров")
                                            .isReadyForRelocation("Да")
                                            .withWorkSchedule(new ArrayList<>(Arrays.asList("Полный день", "Удаленно", "Гибкий график")))
                                            .withPrimaryContact(new Contact("VK", "VK Account"))
                                            .withSecondaryContact(new Contact("WhatsApp", "9991001010"))
                                            .withGender("Мужской")
                                            .withCompany("Self Employed")
                                            .withPosition("Mad scientist")
                                            .build();

        HomePage homePage = new HomePage(driver);
        homePage.open()
                .openLoginForm()
                .loginWithValidCredentials(System.getProperty("username"), System.getProperty("password"))
                .openUserProfile()
                .setUserData(originalUser)
                .saveChanges();

        boolean isConfirmationMessageDisplayed;
        try {
            isConfirmationMessageDisplayed = driver.findElement(By.xpath("//div[contains(@class, 'hide-sm')]//span[@class='success']")).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            isConfirmationMessageDisplayed = false;
        }

        Assert.assertTrue("Save confirmation message isn't displayed", isConfirmationMessageDisplayed);

        driver.manage().deleteAllCookies();

        UserAccount obtainedUser = homePage.open()
                                .openLoginForm()
                                .loginWithValidCredentials(System.getProperty("username"), System.getProperty("password"))
                                .openUserProfile()
                                .getUserAccount();

        Assert.assertEquals(originalUser, obtainedUser);
    }
}