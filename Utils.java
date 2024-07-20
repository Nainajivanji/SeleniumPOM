package com.demo.nopcommerce.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Utils {
    WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void doClick(By locator) {
        getElement(locator).click();
    }

    public void doSendKey(By locator, String value) {
        getElement(locator).sendKeys(value);
    }
}
/*
//    WebDriver Instance:
//    The driver variable is an instance of WebDriver. This is the driver that
//    interacts with the web browser.
//    It is initialized through the constructor when an instance of the Utils
//    class is created.
//     */
//    WebDriver driver;
//    /*
//    Constructor:
//    The constructor Utils(WebDriver driver) initializes the driver instance.
//    This allows the Utils class to use the same WebDriver instance that is used
//    in the page classes and test cases.
//     */
//    public Utils(WebDriver driver){
//
//        this.driver=driver;
//    }
//    /*
//    getElement Method:
//    This method takes a By locator as a parameter and returns the corresponding
//    WebElement.
//    By locator: A locator used to find the element (e.g., By.id, By.name,
//    By.xpath, etc.).
//    WebElement element = driver.findElement(locator): Finds the element on the
//    web page.
//    return element: Returns the found element.
//     */
//    public WebElement getElement(By locator){
//        WebElement element = driver.findElement(locator);
//        return element;
//    }
//    /*
//    doClick Method:
//    This method takes a By locator as a parameter and performs a click action
//     on the corresponding element.
//    It uses the getElement method to find the element and then calls the click
//     method on it.
//     */
//    public void doClick(By locator){
//
//        getElement(locator).click();
//    }
//
//    /*
//    doSendKey Method:
//    This method takes a By locator and a String value as parameters and sends
//    the specified value to the corresponding element.
//    It uses the getElement method to find the element and then calls the
//    sendKeys method on it to input the value.
//     */
//    public void doSendKey(By locator, String value){
//        getElement(locator).sendKeys(value);
//
//    }
//}
/*
Role in the POM Framework
The Utils class is crucial in the POM framework because it:

Promotes Code Reusability:

Methods like doClick and doSendKey are reusable across different page classes and
 test cases. This reduces code duplication and makes the codebase easier to
 maintain.
Improves Readability and Maintainability:

By abstracting common actions (like clicking and sending keys) into utility
methods, test scripts become more readable and easier to understand.
Encapsulates WebDriver Actions:

The Utils class encapsulates WebDriver actions, allowing page classes and test
 cases to interact with web elements without directly dealing with WebDriver methods. This encapsulation follows the principle of abstraction, providing a clean and clear interface for performing actions on web elements.
 */
