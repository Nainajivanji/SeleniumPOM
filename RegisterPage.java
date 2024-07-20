package com.demo.nopcommerce.pages;

import com.demo.nopcommerce.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;
    Utils utils;

    // 1. Create your page object/object repository in the form of by locators.
    By registerLink = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
    By genderID = By.id("gender-female");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By dateOfBirthDay = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]");
    By dateOfBirthMonth = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]");
    By dateOfBirthYear = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]");
    By emailField = By.id("Email");
    By companyName = By.id("Company");
    By newsletter = By.id("Newsletter");
    By passwordField = By.id("Password");
    By confirmPasswordField = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");

    // 2. Create a constructor of page class
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
    }

    // 3. Page Actions
    public void clickOnRegisterLink() {
        utils.doClick(registerLink);
    }

    public void doRegister(String FirstName, String LastName, String DateOfBirthDay, String DateOfBirthMonth, String DateOfBirthYear, String Email, String CompanyName, String Password, String ConfirmPassword) {
        utils.doClick(genderID);
        utils.doSendKey(firstName, FirstName);
        utils.doSendKey(lastName, LastName);
        utils.doSendKey(dateOfBirthDay, DateOfBirthDay);
        utils.doSendKey(dateOfBirthMonth, DateOfBirthMonth);
        utils.doSendKey(dateOfBirthYear, DateOfBirthYear);
        utils.doSendKey(emailField, Email);
        utils.doSendKey(companyName, CompanyName);
        utils.doClick(newsletter);
        utils.doSendKey(passwordField, Password);
        utils.doSendKey(confirmPasswordField, ConfirmPassword);
        utils.doClick(registerButton);
    }
}



