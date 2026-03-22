package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.UserAddressPageObject;
import pageObjects.user.UserCustomerInfoPO;
import pageObjects.user.UserOrderPO;
import pageObjects.user.UserRewardPointPO;
import pageObjects.user.UserHomePO;
import pageObjects.user.UserLoginPO;
import pageObjects.user.UserRegisterPO;


public class Level_08_Test extends BaseTest {
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
    public void beforeClass(String browserDriver) {
       driver=getBrowserDriver(browserDriver);
//       driver = new ChromeDriver();
//       driver.get("http://localhost:8086/");
        //Page duoc sinh ra va bat dau lam nhung action cua page do
        homePage = new UserHomePO(driver);
        firstName = "reimmn";
        lastName = "conanmm";
//        day = "";
//        month = "";
//        year = "";
        emailAddress = "reiconanmm" + generateRandomNumber()  + "@gmail.com";
        companyName = "rei";
        password = "123123";
    }
    //Testcase
    @Test
    public void User_01_Register() {
        registerPage = homePage.openRegisterPage();
        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToCompanyTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
    }
//    @Test
//    public void User_02_Login() {
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
//    }
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