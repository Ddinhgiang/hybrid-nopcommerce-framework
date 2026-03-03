package pageFactory;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageUIs.HomePageUI;

public class HomePageFactory extends BasePage {

    private WebDriver driver;

    //Ham khoi tao (Constructor function)
    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(how = How.CLASS_NAME, using="ico-register")
    private WebElement registerLink;


    @FindBy(className="ico-account")
    private WebElement myAccountLink;

    public void clickToRegisterLink() {
        waitForELementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToELement(driver, HomePageUI.REGISTER_LINK);
    }

    public void clickToLoginLink() {

    }

    public boolean isMyAccountLinkDisplayed() {
        waitForELementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
    }

    public void clickToMyAccountLink() {
        waitForELementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToELement(driver, HomePageUI.MY_ACCOUNT_LINK);
    }
}
