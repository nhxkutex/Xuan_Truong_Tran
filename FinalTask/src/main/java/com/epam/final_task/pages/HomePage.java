package com.epam.final_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class ='T-I J-J5-Ji T-I-KE L3']")
    private WebElement createLetter;

    @FindBy(xpath = "//*[@name='to']")
    private WebElement recieverEmail;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement subjectField;

    @FindBy(xpath = "//div[@aria-label='Тело письма']")
    private WebElement textField;

    @FindBy(xpath = "//*[contains(text(), 'Отправить')]")
    private WebElement sendButton;

    @FindBy(xpath = "//*[@class='yX xY ']")
    private WebElement lastRecievedMessage;

    @FindBy(xpath = "//div[@class='gs']")
    private WebElement lastRecievedMessageInfo;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendMail(String email, String subject, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(createLetter));
        createLetter.click();
        recieverEmail.sendKeys(email);
        subjectField.sendKeys(subject);
        textField.sendKeys(text);
        sendButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(lastRecievedMessage));
    }

    public void getLastMessage() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        lastRecievedMessage.click();
    }

    public String getLastMessageText() {
        return lastRecievedMessageInfo.getText();
    }

}
