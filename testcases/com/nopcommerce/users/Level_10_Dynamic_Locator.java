package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.user.*;


public class Level_10_Dynamic_Locator extends BaseTest {
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
    public void User_04_Dynamic_Page() {
        //CustomerInfo -> Address
        addressPage = (UserAddressPageObject) customerInfoPage.openSidebarLinkByPageName("Addresses");
        //Address -> RewardPoint
        rewardPointPage = (UserRewardPointPO) addressPage.openSidebarLinkByPageName("Reward points");
        //RewardPoint -> Order
        orderPage = (UserOrderPO) rewardPointPage.openSidebarLinkByPageName("Orders");

        //Order -> Address
        addressPage = (UserAddressPageObject) orderPage.openSidebarLinkByPageName("Addresses");

        //Address -> Customer Info
        customerInfoPage = (UserCustomerInfoPO) addressPage.openSidebarLinkByPageName("Customer info");
        rewardPointPage = (UserRewardPointPO) customerInfoPage.openSidebarLinkByPageName("Reward points");
        addressPage = (UserAddressPageObject) rewardPointPage.openSidebarLinkByPageName("Addresses");

    }

    //Trong truong hop nhieu Page
    public void User_05_Dynamic_Page() {
        //CustomerInfo -> Address
        addressPage.openSidebarLinkByPageNames("Reward points");
        rewardPointPage = PageGenerator.getUserRewardPage(driver);
                //Address -> RewardPoint
        rewardPointPage.openSidebarLinkByPageNames("Orders");
        orderPage = PageGenerator.getUserOrderPage(driver);

        //Order -> Address
        orderPage.openSidebarLinkByPageNames("Addresses");
        addressPage = PageGenerator.getUserAddressPage(driver);

        //Address -> Customer Info
        addressPage.openSidebarLinkByPageNames("Customer info");
        customerInfoPage = PageGenerator.getUserCustomerPage(driver);
        customerInfoPage.openSidebarLinkByPageNames("Reward points");
        rewardPointPage = PageGenerator.getUserRewardPage(driver);

        rewardPointPage.openSidebarLinkByPageNames("Addresses");
        addressPage = PageGenerator.getUserAddressPage(driver);

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    //Post-condition
}