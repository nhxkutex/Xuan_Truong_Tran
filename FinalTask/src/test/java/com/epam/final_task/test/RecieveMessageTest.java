package com.epam.final_task.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.epam.final_task.test.data.Data.*;

public class RecieveMessageTest extends BaseTest {

    @Test(description = "Checking for the last recieved mail")
    public void checkMailForRecievingMessage() {
        loginPage.loginToGmail(EMAIL, PASSWORD).sendMail(EMAIL, SUBJECT, TEXT);
        homePage.getLastMessage();
        Assert.assertTrue(homePage.getLastMessageText().contains(TEXT), "Wrong Message");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
