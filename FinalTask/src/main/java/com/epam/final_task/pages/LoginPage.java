package com.epam.final_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='identifierId']")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id='identifierNext']")
    private WebElement loginNextButton;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='passwordNext']")
    private WebElement passwordNextButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage loginToGmail(String login, String password) {
        loginField.clear();
        loginField.sendKeys(login);
        loginNextButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
        passwordNextButton.click();
        return new HomePage(driver);
    }

}
