package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.user.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToMaleRadio() {
        waitForELementClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
        checkToCheckboxRadio(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForELementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }
    public void enterToLastNameTextbox(String lastName) {
        waitForELementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }
//    public void selectDayDropdown(String day) {
//        waitForELementClickable(driver, RegisterPageUI.DAY_DROPDOWN);
//        selectItemInDropdown(driver, RegisterPageUI.DAY_DROPDOWN, day);
//    }
//
//    public void selectMonthDropdown(String month) {
//        waitForELementClickable(driver, RegisterPageUI.MONTH_DROPDOWN);
//        selectItemInDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, month);
//    }
//
//    public void selectYearDropdown(String year) {
//        waitForELementClickable(driver, RegisterPageUI.YEAR_DROPDOWN);
//        selectItemInDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, year);
//    }
    public void enterToEmailTextbox(String emailAddress) {
        waitForELementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }


    public void enterToPasswordTextbox(String password) {
        waitForELementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextbox(String password) {
        waitForELementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }
    public void enterToCompanyTextbox(String companyName) {
        waitForELementVisible(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, companyName);
    }
    public void clickToRegisterButton() {
        waitForELementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToELement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }
    public String getRegisterSuccessMessage() {
        waitForELementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }
    /**Them**/
    public UserCustomerInfoPO openCustomerInfoPage() {
        waitForELementClickable(driver, UserRegisterPageUI.MY_ACCOUNT_LINK);
        clickToELement(driver, UserRegisterPageUI.MY_ACCOUNT_LINK);
        return new UserCustomerInfoPO(driver);
    }

    public void clickToLogoutLink() {
        waitForELementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
        clickToELement(driver, UserRegisterPageUI.LOGOUT_LINK);
    }
    public UserLoginPO openLoginPO() {
        waitForELementClickable(driver, UserRegisterPageUI.LOGIN_LINK);
        clickToELement(driver, UserRegisterPageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }



}
