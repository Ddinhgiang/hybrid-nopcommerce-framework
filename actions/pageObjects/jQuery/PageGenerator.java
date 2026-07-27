package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static HomePO getHomePO (WebDriver driver) {
        return new HomePO(driver);
    }
}
