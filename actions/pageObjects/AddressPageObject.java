package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AddressPageObject extends BasePage {
    private WebDriver driver;
    public AddressPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RewardPointPageObject openRewardPointPage() {
        return PageGenerator.getRewardPage(driver);
    }

    public CustomerInfoPageObject openCustomerInfoPage() {
        //wait
        //click
        return PageGenerator.getCustomerPage(driver);
    }
}
