package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.user.UserAddressPageObject;
import pageObjects.user.UserCustomerInfoPO;
import pageObjects.user.UserOrderPO;
import pageObjects.user.UserRewardPointPO;
import pageObjects.user.UserHomePO;
import pageObjects.user.UserLoginPO;
import pageObjects.user.UserRegisterPO;


public class Level_09_Switch_Page_Url extends BaseTest {
   // Declare Variables
    private String userUrl, adminUrl;
    private WebDriver driver;
    private UserHomePO userHomePage;
    private UserRegisterPO userRegisterPage;
    private UserLoginPO userLoginPage;
    private String firstName, lastName, day, month, year, emailAddress, companyName, password;
    @Parameters({"browser", "userUrl", "adminUrl"})
    //Pre-Condition
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {
        this.userUrl = userUrl;
        this.adminUrl = adminUrl;
        driver=getBrowserDriver(browserName, this.userUrl);
        //Page duoc sinh ra va bat dau lam nhung action cua page do
        userHomePage = PageGenerator.getUserHomePage(driver);
        firstName = "rei";
        lastName = "conan";
//        day = "";
//        month = "";
//        year = "";
        emailAddress = "reiconan" + generateRandomNumber()  + "@gmail.com";
        companyName = "rei";
        password = "123123";

        userRegisterPage = userHomePage.openRegisterPage();
        userRegisterPage.clickToMaleRadio();
        userRegisterPage.enterToFirstNameTextbox(firstName);
        userRegisterPage.enterToLastNameTextbox(lastName);
        userRegisterPage.enterToEmailTextbox(emailAddress);
        userRegisterPage.enterToCompanyTextbox(companyName);
        userRegisterPage.enterToPasswordTextbox(password);
        userRegisterPage.enterToConfirmPasswordTextbox(password);
        userRegisterPage.clickToRegisterButton();
        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(),"Your registration completed");
    }
    //Testcase
    @Test
    public void Role_01_User_Site_To_Admin_Site() {
<<<<<<< Updated upstream
=======
        userRegisterPage.clickToLogoutLink();
        userLoginPage = userRegisterPage.openLoginPO();
        userHomePage = userLoginPage.loginToSystem(emailAddress, password);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
        userHomePage.openPageUrl(driver, this.adminUrl);
        //Chua login >> Khoi tao Login
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);

        //Login vao trang Admin
        adminLoginPage.enterToEmailTextbox(adminEmaillAddress);
        adminLoginPage.enterToPasswordTextbox(adminPassword);
        adminDashboardPage = adminLoginPage.clickToLoginButton();

>>>>>>> Stashed changes

    }
    @Test
    public void Role_02_Admin_Site_To_User_Site() {

    }
    @Test
    public void User_03_MyAccount() {

    }
    @Test
    public void User_04_Switch_Page() {

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    //Post-condition
}