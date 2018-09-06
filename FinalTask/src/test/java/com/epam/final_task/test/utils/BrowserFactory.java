package com.epam.final_task.test.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.epam.final_task.test.data.Data.GMAIL;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class BrowserFactory {

    private static WebDriver driver;

    public static WebDriver startBrowser(String browserName) throws Exception {
        if (FIREFOX.equalsIgnoreCase(browserName)) {
            driver = new FirefoxDriver();
        } else if (CHROME.equalsIgnoreCase(browserName)) {
            driver = new ChromeDriver();
        } else {
            throw new Exception("Browser was not found");
        }
        driver.manage().window().maximize();
        driver.get(GMAIL);
        return driver;
    }
}
