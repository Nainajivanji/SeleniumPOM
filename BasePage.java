package com.demo.nopcommerce.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/*
In the context of a Page Object Model (POM) framework in IntelliJ IDEA, the
BasePage class serves as a foundational class that provides common setup and
utility methods which are used across different page classes. This helps in
 maintaining consistency and reducing code duplication. Below is a detailed explanation of the BasePage class:
 */
public class BasePage {
    WebDriver driver;
    Properties prop;
    FileInputStream file;


    public WebDriver initialiseDriver(String browserName){
        if(browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browserName.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if(browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else {
            System.out.println("Browser not matched");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        return driver;
    }
    public Properties initialiseProperties(){
        prop = new Properties();
        try {
           // file = new FileInputStream("C:\\Testing\\Oct2023BatchPOM\\src\\test\\resources\\TestData\\config.properties");
            file=new FileInputStream("C:\\Users\\Admin\\IdeaProjects\\SeleniumPOM\\src\\test\\resources\\TestData\\config.properties");
            prop.load(file);
        }catch (FileNotFoundException e){;
            System.out.println("Config file is not found, Please check...");
        }catch (IOException e){
            System.out.println("Properties could not be loaded");
        }
        return prop;
    }
}
/*
Components of the BasePage Class
WebDriver Instance:

The driver variable is an instance of WebDriver, which is used to control the web
 browser.
Properties Instance:

The prop variable is an instance of Properties, which is used to manage
 configuration properties for the test framework.
FileInputStream Instance:

The file variable is an instance of FileInputStream, used to read data from the
configuration file.
InitialiseDriver Method:

This method initializes the WebDriver based on the specified browser name.
It supports Chrome, Edge, and Firefox browsers by using the WebDriverManager to set
 up the appropriate driver.
After setting up the driver, it maximizes the browser window and deletes all
cookies for a clean start.
The initialized WebDriver instance is returned for use in the test cases or page
classes.
InitialiseProperties Method:

This method initializes the Properties object by loading configuration data from
a properties file.
It attempts to load the properties file located at the specified path.
If the file is not found, it catches a FileNotFoundException and prints an error
 message.
If there is an issue with loading the properties, it catches an IOException and
prints an error message.
The loaded Properties object is returned for use in the framework.
Role in the POM Framework
The BasePage class in a POM framework is crucial because it:

Centralizes Common Setup:

The BasePage class centralizes the setup and initialization of WebDriver and
configuration properties, ensuring consistency across different page classes and
test cases.
Promotes Code Reusability:

By providing common utility methods, such as initialiseDriver and
initialiseProperties, the BasePage class reduces code duplication and promotes reusability.
Facilitates Maintenance:

Centralizing WebDriver and property initialization in the BasePage class makes it
easier to maintain and update the framework. Changes to browser setup or configuration properties only need to be made in one place.
 */