package com.otus.tests;

import com.otus.testdata.UserAccount;
import com.otus.webpages.HomePage;
import com.otus.webpages.UserProfilePage;
import org.junit.*;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;


public class OtusUserProfileTest extends BaseTest {

    @Test
    public void savePersonalInfoTest() {
        UserAccount user = new UserAccount();
        user.init();

        HomePage homePage = new HomePage(driver);
        homePage.open();

        homePage.openLoginForm()
                .loginWithValidCredentials(System.getProperty("username"), System.getProperty("password"))
                .openUserProfile()
                .setFirstName(user.firstName)
                .setFirstNameLatin(user.firstNameLatin)
                .setLastName(user.lastName)
                .setLastNameLatin(user.lastNameLatin)
                .setBlogName(user.blogName)
                .setBirthDate(user.birthDate)
                .setCountry(user.country)
                .setCity(user.city)
                .setIsRelocationReady(user.isReadyForRelocation)
                .setWorkSchedule(user.workSchedule)
                .setGender(user.gender)
                .deleteAllContactFields()
                .addContactField()
                .setContact(user.contactOne.contactType, user.contactOne.contactValue)
                .addContactField()
                .setContact(user.contactTwo.contactType, user.contactTwo.contactValue)
                .setCompany(user.company)
                .setPosition(user.position)
                .saveChanges();

        assert driver.findElement(By.xpath("//div[contains(@class, 'hide-sm')]//span[@class='success']")).isDisplayed();

        driver.manage().deleteAllCookies();

        homePage.open();
        UserProfilePage userProfilePage = homePage.openLoginForm()
                                                    .loginWithValidCredentials(System.getProperty("username"), System.getProperty("password"))
                                                    .openUserProfile();

        assertEquals(user.firstName, userProfilePage.getFirstName());
        assertEquals(user.firstNameLatin, userProfilePage.getFirstNameLatin());
        assertEquals(user.lastName, userProfilePage.getLastName());
        assertEquals(user.lastNameLatin, userProfilePage.getLastNameLatin());
        assertEquals(user.blogName, userProfilePage.getBlogName());
        assertEquals(user.birthDate, userProfilePage.getBirthDate());
        assertEquals(user.country, userProfilePage.getCountry());
        assertEquals(user.city, userProfilePage.getCity());
        assertEquals(user.isReadyForRelocation, userProfilePage.getIsRelocationReady());
        assertEquals(user.gender, userProfilePage.getGender());
        assertEquals(user.company, userProfilePage.getCompany());
        assertEquals(user.position, userProfilePage.getPosition());

        ArrayList<String> arr1 = user.workSchedule;
        Collections.sort(arr1);
        ArrayList<String> arr2 = userProfilePage.getWorkSchedule();
        Collections.sort(arr2);

        assertTrue(arr1.equals(arr2));

        //assertTrue(user.contactOne.equals(userProfilePage.getContact(1)));
        //assertTrue(user.contactTwo.equals(userProfilePage.getContact(2)));
        assertEquals(user.contactOne.contactType, userProfilePage.getContact(1).contactType);
        assertEquals(user.contactOne.contactValue, userProfilePage.getContact(1).contactValue);
        assertEquals(user.contactTwo.contactType, userProfilePage.getContact(2).contactType);
        assertEquals(user.contactTwo.contactValue, userProfilePage.getContact(2).contactValue);

        return;
    }
}