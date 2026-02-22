package com.nopcommerce.users;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.Random;

public class Level_01_Repeat_Yourself {
    private WebDriver driver;
    private String firstName, lastName, emailAddress, companyName, password;
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=C:/Users/ADMIN/AppData/Local/Google/Chrome/User Data/");
        chromeOptions.addArguments("profile-directory=Profile 4");
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(chromeOptions);

        driver.get("https://demo.nopcommerce.com/");
        // Sau khi driver.get()
        ((JavascriptExecutor)driver).executeScript(
                "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        firstName = "amuro";
        lastName = "rei";
        emailAddress = "amurorei" +generateRandomNumber()+ "@gmail.com";
        companyName = "REI";
        password = "123123";
    }
    @Test
    public void TC_01_Register() {
        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.cssSelector("input#gender-male")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Company")).sendKeys(companyName);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");
    }
    @Test
    public void TC_02_Login() {
        driver.findElement(By.cssSelector("a.ico-login")).click();
        driver.findElement(By.cssSelector("input.email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input.password")).sendKeys(password);
        driver.findElement(By.cssSelector("button.login-button")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("a.ico-account")).isDisplayed());

    }
    @Test
    public void TC_03_MyAccount() {
        driver.findElement(By.cssSelector("a.ico-account")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input#gender-male")).isSelected());
        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"),emailAddress);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"),companyName);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int generateRandomNumber() {
        return new Random().nextInt(9999);
    }
}