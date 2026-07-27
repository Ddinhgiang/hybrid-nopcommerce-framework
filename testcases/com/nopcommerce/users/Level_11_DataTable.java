package com.nopcommerce.users;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.HomePO;
import pageObjects.jQuery.PageGenerator;

//33.48

public class Level_11_DataTable extends BaseTest {
   // Declare Variables
    private WebDriver driver;
    private HomePO homePage;

    @Parameters({"browser", "url"})
    //Pre-Condition
    @BeforeClass
    public void beforeClass(String browserName, String url) {
       driver = getBrowserDriver(browserName, url);
       homePage = PageGenerator.getHomePO(driver);

    }
//    @Test
//    public void Table_01_Paging() {
//      //1. Mo ra 1 trang bat ky
//     homePage.openPageByNumber("10");
//     Assert.assertTrue(homePage.isPageActivedByNumber("10"));
//     homePage.openPageByNumber("5");
//     Assert.assertTrue(homePage.isPageActivedByNumber("5"));
//    }
    @Test
    public void Table_02_Search() {
     homePage.enterToHeaderTextboxByName("Country", "Afghanistan");
     Assert.assertTrue(homePage.isPageInforDisplayed("384187","Afghanistan","407124","791312"));
     homePage.refreshCurrentPage(driver);
     homePage.sleepInSecond(3);

     homePage.enterToHeaderTextboxByName("Females", "21050");
     homePage.refreshCurrentPage(driver);
     homePage.sleepInSecond(3);


    }



 @AfterClass
    public void afterClass() {
        driver.quit();
    }
    //Post-condition
}