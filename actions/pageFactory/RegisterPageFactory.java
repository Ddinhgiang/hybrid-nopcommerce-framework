package pageFactory;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUIs.RegisterPageUI;

public class RegisterPageFactory extends BasePageFactory {
    private WebDriver driver;

    public RegisterPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="gender-male")
    private WebElement genderMaleRadio;

    @FindBy(id="FirstName")
    private WebElement firstNameTextbox;

    @FindBy(id="LastName")
    private WebElement lastNameTextbox;
//    @FindBy(xpath="")
//    private WebElement dayDropdown;
//    @FindBy(xpath="")
//    private WebElement monthDropdown;
//    @FindBy(xpath="")
//    private WebElement yearDropdown;
    @FindBy(id="Email")
    private WebElement emailTextbox;

    @FindBy(id="Password")
    private WebElement passwordTextbox;

    @FindBy(id="ConfirmPassword")
    private WebElement confirmPasswordTextbox;

    @FindBy(id="Password")
    private WebElement comapanyTextbox;

    @FindBy(id="register-button")
    private WebElement registerButton;

    @FindBy(xpath="//div[@class='result']")
    private WebElement registerSuccessMessage;

    @FindBy(className="ico-account")
    private WebElement myAccountLink;

    public void clickToMaleRadio() {
        waitForElementClickable(driver, genderMaleRadio);
        checkToCheckboxRadio(driver, genderMaleRadio);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisibled(driver, firstNameTextbox);
        sendKeyToElement(firstNameTextbox, firstName);
    }
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisibled(driver, lastNameTextbox);
        sendKeyToElement(lastNameTextbox, lastName);
    }
//    public void selectDayDropdown(String day) {
//         waitForElementClickable(driver, dayDropdown);
//       selectItemInDropdown(dayDropdown, day);
//    }
//
//    public void selectMonthDropdown(String month) {
//        waitForElementClickable(driver, monthDropdown);
//         selectItemInDropdown(monthDropdown, month);
//    }
//
//    public void selectYearDropdown(String year) {
//         selectItemInDropdown(driver, yearDropdown);
//        selectItemInDropdown((yearDropdown, year);
//    }
    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisibled(driver, emailTextbox);
        sendKeyToElement(emailTextbox, emailAddress);
    }


    public void enterToPasswordTextbox(String password) {
        waitForElementVisibled(driver, passwordTextbox);
        sendKeyToElement(passwordTextbox, password);
    }

    public void enterToConfirmPasswordTextbox(String password) {
        waitForElementVisibled(driver, confirmPasswordTextbox);
        sendKeyToElement(confirmPasswordTextbox, password);
    }
    public void enterToCompanyTextbox(String companyName) {
        waitForElementVisibled(driver, comapanyTextbox);
        sendKeyToElement(comapanyTextbox, companyName);
    }
    public void clickToRegisterButton() {
        waitForElementVisibled(driver, registerButton);
        clickToELement(registerButton);
    }
    public String getRegisterSuccessMessage() {
        waitForElementVisibled(driver,registerSuccessMessage);
        return getElementText(registerSuccessMessage);
    }
    /**Them**/
    public void clickToMyAccountLink() {
        waitForElementClickable(driver, myAccountLink);
        clickToELement(myAccountLink);
    }

//    public void clickToLoginLink() {
//        waitForELementClickable(driver, RegisterPageUI.LOGIN_LINK);
//        clickToELement(driver, RegisterPageUI.LOGIN_LINK);
//    }



}
