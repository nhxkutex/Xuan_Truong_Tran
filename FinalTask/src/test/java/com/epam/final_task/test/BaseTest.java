package com.epam.final_task.test;

import com.epam.final_task.pages.HomePage;
import com.epam.final_task.pages.LoginPage;
import com.epam.final_task.test.utils.BrowserFactory;
import com.epam.final_task.test.utils.TestReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.openqa.selenium.remote.BrowserType.CHROME;

public abstract class BaseTest {

    protected WebDriver driver;
    protected TestReporter reporter = new TestReporter();
    public static LoginPage loginPage;
    public static HomePage homePage;


    @BeforeClass
    public void createReporter() {
        reporter.createReport();
    }

    @BeforeTest
    public void startBrowser() throws Exception {
        driver = BrowserFactory.startBrowser(CHROME);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void initReporter(Method method) {
        reporter.init(method);
    }

    @AfterMethod
    public void addResult(ITestResult result) {
        reporter.addReport(result);
    }

    @AfterClass
    public void tearDown() {
        reporter.close();
    }
}
