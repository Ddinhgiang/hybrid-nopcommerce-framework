package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User_01_Register_Login {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8086/");

    }
    @Test
    public void TC_01_Register() throws InterruptedException {
        Thread.sleep(5000);
    }
    @Test
    public void TC_02_Login() {

    }

    @AfterClass
    public void afterClass() {

    }
}
