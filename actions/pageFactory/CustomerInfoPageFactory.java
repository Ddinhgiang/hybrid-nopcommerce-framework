package pageFactory;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageFactory extends BasePageFactory {
    private WebDriver driver;
    public CustomerInfoPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="gender-male")
    private WebElement genderMaleRadio;

    @FindBy(id="FirstName")
    private WebElement firstNameTextbox;

    @FindBy(id="LastName")
    private WebElement lastNameTextbox;

    @FindBy(id="Email")
    private WebElement emailTextbox;

    @FindBy(id="Company")
    private WebElement companyTextbox;

//    @FindBy(id="")
//    private WebElement dayDropdown;
//
//    @FindBy(id="")
//    private WebElement monthDropdown;
//
//    @FindBy(id="")
//    private WebElement yearDropdown;


    public boolean isGenderMaleSelected() {
        waitForELementSelected(driver, genderMaleRadio);
        return isElementSelected(genderMaleRadio);
    }

    public String getFirstNameTextboxValue() {
       waitForElementVisibled(driver, firstNameTextbox);
        return getElementAttribute(firstNameTextbox, "value");
    }
    public String getLastNameTextboxValue() {
        waitForElementVisibled(driver, lastNameTextbox);
        return getElementAttribute(lastNameTextbox, "value");
    }

    public String getEmailTextboxValue() {
        waitForElementVisibled(driver, emailTextbox);
        return getElementAttribute(emailTextbox, "value");
    }

    public String getCompanyTextboxValue() {
       waitForElementVisibled(driver, companyTextbox);
        return getElementAttribute(companyTextbox, "value");

    }

//    public String getDayDropdownSelectedValue() {
//        waitForElementClickable(driver, dayDropdown);
//        return getSelectedItemInDropdown(dayDropdown);
//    }
//
//    public String getMonthDropdownSelectedValue() {
//       waitForElementClickable(driver, monthDropdown);
//       return getSelectedItemInDropdown(monthDropdown);;
//    }
    //    public String getYearDropdownSelectedValue() {
//       waitForElementClickable(driver, yearDropdown);
//       return getSelectedItemInDropdown(yearDropdown);;
//    }
}
