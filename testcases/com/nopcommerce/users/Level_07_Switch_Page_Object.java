package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPO;
import pageObjects.nopCommerce.user.UserOrderPO;
import pageObjects.nopCommerce.user.UserRewardPointPO;
import pageObjects.nopCommerce.user.UserHomePO;
import pageObjects.nopCommerce.user.UserLoginPO;
import pageObjects.nopCommerce.user.UserRegisterPO;


public class Level_07_Switch_Page_Object extends BaseTest {
   // Declare Variables
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserAddressPageObject addressPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;
    private String firstName, lastName, day, month, year, emailAddress, companyName, password;
    @Parameters("browser")
    //Pre-Condition
    @BeforeClass
    public void beforeClass(String browserName) {
       driver=getBrowserDriver(browserName);
        //Page duoc sinh ra va bat dau lam nhung action cua page do
        homePage = new UserHomePO(driver);
        firstName = "rei";
        lastName = "conan";
//        day = "";
//        month = "";
//        year = "";
        emailAddress = "reiconan" + generateRandomNumber()  + "@gmail.com";
        companyName = "rei";
        password = "123123";
    }
    //Testcase
    @Test
    public void User_01_Register() {
        //Action 1
        registerPage = homePage.openRegisterPage();
        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
//        registerPage.selectDayDropdown(day);
//        registerPage.selectMonthDropdown(month);
//        registerPage.selectYearDropdown(year);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToCompanyTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
    }
    @Test
    public void User_02_Login() {
////        registerPage.clickToLoginLink();
//        homePage.clickToLoginLink();
//        //Tu register page qua login page (Actual: home page -> login page)
//        //Page do duoc sinh ra va lam nhung action cua page do
//        loginPage = new LoginPageObject(driver);
////        loginPage.enterToEmailTextbox(emailAddress);
////        loginPage.enterToPasswordTextbox(password);
////        loginPage.clickToLoginButton();
//        loginPage.loginToSystem(emailAddress, password);
//
//        //Tu Login qua Home Page
//        //Page do duoc sinh ra va bat dau nhung action cua no
//        homePage = new HomePageObject(driver);
//        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }
    @Test
    public void User_03_MyAccount() {
        //Tu Home Page qua Customer Info Page
        //Page duoc sinh ra va bat dau nhung action cua no
//        homePage.clickToMyAccountLink();
        customerInfoPage = registerPage.openCustomerInfoPage();

        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
//        Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue(),day);
//        Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue(),month);
//        Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue(),year);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(),companyName);
    }
    @Test
    public void User_04_Switch_Page() {
        //CustomerInfo -> Address
        addressPage = customerInfoPage.openAddressPage();
        //Address -> RewardPoint
        rewardPointPage = addressPage.openRewardPointPage();
        //RewardPoint -> Order
        orderPage = rewardPointPage.openOrderPage();

        //Order -> Address
        addressPage = orderPage.openAddressPage();

        //Address -> Customer Info
        customerInfoPage = addressPage.openCustomerInfoPage();


    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    //Post-condition
}