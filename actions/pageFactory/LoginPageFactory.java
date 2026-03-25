package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends pageFactory.BasePageFactory {
    private WebDriver driver;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//input[@id='Email']")
    private WebElement emailTextbox;
    @FindBy(id="Password")
    private WebElement passwordTextbox;
    @FindBy(xpath="//button[contains(@class,'login-button')]")
    private WebElement loginButton;


    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisibled(driver, emailTextbox);
        sendKeyToElement(emailTextbox, emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisibled(driver, passwordTextbox);
        sendKeyToElement(passwordTextbox, password);
    }


    public void clickToLoginButton() {
        waitForElementClickable(driver, loginButton);
        clickToELement(loginButton);
    }
    public void loginToSystem(String emailAddress, String password) {
        enterToEmailTextbox(emailAddress);
        enterToPasswordTextbox(password);
        clickToLoginButton();
    }
}
