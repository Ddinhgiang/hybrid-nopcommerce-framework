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

public class Level_02_BasePage_I_Init {
    private WebDriver driver;
    BasePage basePage;
    private String firstName, lastName, emailAddress, companyName, password;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        basePage = new BasePage(); //Initial
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
        basePage.waitForELementClickable(driver, "//a[@class='ico-register']");
        basePage.clickToELement(driver, "//a[@class='ico-register']");
        basePage.waitForELementClickable(driver, "//input[@id='gender-male']");
        basePage.clickToELement(driver, "//input[@id='gender-male']");
        basePage.sendKeyToElement(driver, "/input[@id='FirstName']", firstName);
        basePage.sendKeyToElement(driver, "/input[@id='LastName']", lastName);
        basePage.sendKeyToElement(driver, "/input[@id='Email']", emailAddress);
        basePage.sendKeyToElement(driver, "/input[@id='Company']", companyName);
        basePage.sendKeyToElement(driver, "/input[@id='Password']", password);
        basePage.sendKeyToElement(driver, "/input[@id='ConfirmPassword']", password);
        basePage.waitForELementClickable(driver, "//button[@id='register-button']");
        basePage.clickToELement(driver, "//button[@id='register-button']");
        Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result]"),"Your registration completed");
    }
    @Test
    public void TC_02_Login() {
        basePage.waitForELementClickable(driver, "//a[@class='ico-login']");
        basePage.clickToELement(driver, "//a[@class='ico-login']");
        basePage.sendKeyToElement(driver, "/input[@class='email']", emailAddress);
        basePage.sendKeyToElement(driver, "/input[@class='password']", password);
        basePage.waitForELementClickable(driver, "//button[contains(@class,'login-button')]");
        basePage.clickToELement(driver, "//button[contains(@class,'login-button')]");
        Assert.assertTrue(basePage.isElementDisplayed(driver, "//a[@class='ico-account'"));
    }
    @Test
    public void TC_03_MyAccount() {
        basePage.waitForELementClickable(driver, "//a[@class='ico-account']");
        basePage.clickToELement(driver, "//a[@class='ico-login']");
        Assert.assertTrue(basePage.isElementSelected(driver,"//input[@id='gender-male']"));
        Assert.assertEquals(basePage.getCssValue(driver, "//input[@id='FirstName']","value"), firstName);
        Assert.assertEquals(basePage.getCssValue(driver, "//input[@id='LastName']","value"), lastName);
        Assert.assertEquals(basePage.getCssValue(driver, "//input[@id='Email']","value"), emailAddress);
        Assert.assertEquals(basePage.getCssValue(driver, "//input[@id='Company']","value"), companyName);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int generateRandomNumber() {
        return new Random().nextInt(9999);
    }
}