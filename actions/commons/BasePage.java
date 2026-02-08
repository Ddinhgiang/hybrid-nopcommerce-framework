package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public boolean isElementDisplayed() {
        return driver.findElement(By.cssSelector("")).isDisplayed();
    }
    private WebDriver driver;
    public void clickToElement() {
        driver.findElement(By.cssSelector("")).click();
    }

    public String getElementText() {
        return driver.findElement(By.cssSelector("")).getText();
    }
    public void senKeyToElement(String valueToSendKey) {
        driver.findElement(By.cssSelector("")).sendKeys(valueToSendKey);
    }

}
