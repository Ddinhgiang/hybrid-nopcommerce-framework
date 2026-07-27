package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPO extends UserSidebarPO {
    private WebDriver driver;
    public UserCustomerInfoPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isGenderMaleSelected() {
        waitForELementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
        return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
    }

    public String getFirstNameTextboxValue() {
        waitForELementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }
    public String getLastNameTextboxValue() {
        waitForELementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }


    public String getEmailTextboxValue() {
        waitForELementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getCompanyTextboxValue() {
        waitForELementVisible(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX, "value");

    }

    public UserAddressPageObject openAddressPage() {
        waitForELementClickable(driver, UserCustomerInfoPageUI.ADDRESS_LINK);
        clickToELement(driver, UserCustomerInfoPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }


//    public String getDayDropdownSelectedValue() {
//        waitForELementClickable(driver, CustomerInfoPageUI.DAY_DROPDOWN);
//        return getSelectedItemInDropdown(driver, CustomerInfoPageUI.DAY_DROPDOWN);
//    }
//
//    public String getMonthDropdownSelectedValue() {
//        waitForELementClickable(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
//        return getSelectedItemInDropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
//    }
//
//    public String getYearDropdownSelectedValue() {
//        waitForELementClickable(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
//        return getSelectedItemInDropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
//    }
}
