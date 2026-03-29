package pageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePageFactory {


    public void clickToELement(WebElement element) {
//        driver.findElement(By.xpath(locator)).click();
        element.click();
    }
    public void sendKeyToElement(WebElement element, String keyToSend) {
        element.clear();
        element.sendKeys(keyToSend);
    }
    public void selectItemInDropdown(WebElement element, String textItem) {
        new Select(element).selectByVisibleText(textItem);
    }
    public String getSelectedItemInDropdown(WebElement element) {
        return new Select(element).getFirstSelectedOption().getText();
    }

    public String getElementAttribute(WebElement element, String attributeName ) {
        return element.getAttribute(attributeName);
    }
    public String getElementText(WebElement element) {
        return element.getText();
    }
    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }
    public void waitForElementVisibled(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
    }
    public void checkToCheckboxRadio(WebDriver driver, WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }
    public void waitForELementSelected(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeSelected(element));
    }
    public boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }
}
