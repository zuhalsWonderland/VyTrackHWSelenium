package com.cybertek.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    //Task:
    //write a static method that takes a String parameter name is browserType
    //based on the value of the parameter
    //it will set up the browser and the method will be return chrome driver or firefox driver object
    //name of the method : getDriver

    public static WebDriver getDriver(String browserType) {
//        WebDriver driver = null;
//        if (browserType.equalsIgnoreCase("firefox")) {
//
//            WebDriverManager.firefoxdriver().setup();
//
//            driver = new FirefoxDriver();
//
//
//        } else if (browserType.equalsIgnoreCase("chrome")) {
//
//            WebDriverManager.chromedriver().setup();
//
//            driver = new ChromeDriver();
//        }
//            return driver;
        WebDriver driver = null;
        switch (browserType.toLowerCase()){
            case "chrome":

                WebDriverManager.chromedriver().setup();

                driver = new ChromeDriver();

                break;
            case"firefox":
                WebDriverManager.firefoxdriver().setup();

                driver = new FirefoxDriver();
                break;
        }
        return driver;


    }
}
