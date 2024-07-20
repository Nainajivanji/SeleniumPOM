package com.demo.nopcommerce;

import com.demo.nopcommerce.base.BasePage;
import com.demo.nopcommerce.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginPageTest {
    /*
    WebDriver driver: The WebDriver instance that will be used to control the
    browser.
    BasePage basePage: An instance of BasePage that likely contains methods for
     initializing the WebDriver and properties.
    Properties prop: An instance of Properties to load configuration settings such
    as browser type and URL.
    LoginPage loginPage: An instance of LoginPage that contains methods for
    interacting with the login page.
     */
    WebDriver driver;
    BasePage basePage;
    Properties prop;
    LoginPage loginPage;
    @BeforeClass
    void openBrowser(){
    /*
    openBrowser(): This method sets up the environment for the test:
    Initializes the BasePage object.
    Loads properties from a configuration file using initialiseProperties() method.
    Retrieves the browser type from the properties file.
    Initializes the WebDriver based on the browser type using initialiseDriver() method.
    Navigates to the URL specified in the properties file.
    Initializes the LoginPage object with the WebDriver instance.
     */
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String webengine =  prop.getProperty("browser");
        driver = basePage.initialiseDriver(webengine);
        driver.get(prop.getProperty("url"));
        loginPage = new LoginPage(driver);
    }
    @Test
    /*
    LoginTest(): This method performs the following actions:
    Clicks on the login link on the page.
    Retrieves the title of the login page.
    Performs the login action using the username and password from the properties file.
         */
    void loginTest(){
        loginPage.clickOnLoginLink();
        loginPage.getLoginPageTitle();
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }
    @AfterClass
    void closeBrowser(){
        driver.quit();
    }

}

