package com.otus.tests;

import com.otus.utils.Constants;
import com.otus.utils.WebDriverFactory;
import com.otus.utils.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = WebDriverFactory.createDriver(WebDriverType.valueOf("CHROME"));
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void teardown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
