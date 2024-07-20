package com.demo.nopcommerce;

import com.demo.nopcommerce.base.BasePage;
import com.demo.nopcommerce.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;


public class RegisterPageTest {
    WebDriver driver;
    BasePage basePage;
    Properties prop;
    RegisterPage registerPage;

    @BeforeClass
    public void openBrowser() {
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String webengine = prop.getProperty("browser");
        driver = basePage.initialiseDriver(webengine);
        driver.get(prop.getProperty("url"));
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void registerTest() {
        registerPage.clickOnRegisterLink();
        registerPage.doRegister(prop.getProperty("FirstName"),
                prop.getProperty("LastName"),
                prop.getProperty("DateOfBirthDay"),
                prop.getProperty("DateOfBirthMonth"),
                prop.getProperty("DateOfBirthYear"),
                prop.getProperty("Email"),
                prop.getProperty("CompanyName"),
                prop.getProperty("Password"),
                prop.getProperty("ConfirmPassword"));
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}


