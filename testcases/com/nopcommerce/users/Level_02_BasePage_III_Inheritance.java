package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_III_Inheritance extends BasePage {
    private WebDriver driver;

    private String firstName, lastName, emailAddress, companyName, password;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        firstName = "amuro";
        lastName = "rei";
        emailAddress = "amurorei" +generateRandomNumber()+ "@gmail.com";
        companyName = "REI";
        password = "123123";
    }
    @Test
    public void TC_01_Register() {
        waitForELementClickable(driver, "//a[@class='ico-register']");
        clickToELement(driver, "//a[@class='ico-register']");
        waitForELementClickable(driver, "//input[@id='gender-male']");
        clickToELement(driver, "//input[@id='gender-male']");
        sendKeyToElement(driver, "/input[@id='FirstName']", firstName);
        sendKeyToElement(driver, "/input[@id='LastName']", lastName);
        sendKeyToElement(driver, "/input[@id='Email']", emailAddress);
        sendKeyToElement(driver, "/input[@id='Company']", companyName);
        sendKeyToElement(driver, "/input[@id='Password']", password);
        sendKeyToElement(driver, "/input[@id='ConfirmPassword']", password);
        waitForELementClickable(driver, "//button[@id='register-button']");
        clickToELement(driver, "//button[@id='register-button']");
        Assert.assertEquals(getElementText(driver, "//div[@class='result]"),"Your registration completed");
    }
    @Test
    public void TC_02_Login() {
        waitForELementClickable(driver, "//a[@class='ico-login']");
        clickToELement(driver, "//a[@class='ico-login']");
        sendKeyToElement(driver, "/input[@class='email']", emailAddress);
        sendKeyToElement(driver, "/input[@class='password']", password);
        waitForELementClickable(driver, "//button[contains(@class,'login-button')]");
        clickToELement(driver, "//button[contains(@class,'login-button')]");
        Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account'"));
    }
    @Test
    public void TC_03_MyAccount() {
        waitForELementClickable(driver, "//a[@class='ico-account']");
        clickToELement(driver, "//a[@class='ico-login']");
        Assert.assertTrue(isElementSelected(driver,"//input[@id='gender-male']"));
        Assert.assertEquals(getCssValue(driver, "//input[@id='FirstName']","value"), firstName);
        Assert.assertEquals(getCssValue(driver, "//input[@id='LastName']","value"), lastName);
        Assert.assertEquals(getCssValue(driver, "//input[@id='Email']","value"), emailAddress);
        Assert.assertEquals(getCssValue(driver, "//input[@id='Company']","value"), companyName);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int generateRandomNumber() {
        return new Random().nextInt(9999);
    }
}