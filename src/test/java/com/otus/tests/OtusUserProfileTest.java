package com.otus.tests;

import com.otus.testdata.UserAccount;
import com.otus.utils.Utilities;
import com.otus.webpages.HomePage;
import com.otus.webpages.UserProfilePage;
import org.junit.*;
import org.openqa.selenium.*;
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
                .setUserData(user)
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
        assertTrue(Utilities.areEqualArrays(user.workSchedule, userProfilePage.getWorkSchedule()));
        assertEquals(user.contactOne, userProfilePage.getContact(1));
        assertEquals(user.contactTwo, userProfilePage.getContact(2));
    }
}