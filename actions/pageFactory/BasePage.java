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

public class BasePage {




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
    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        return  new Select(driver.findElement(By.xpath(locator))).isMultiple();
    }
    private void selectItemCustomDropDown(WebDriver driver,String parentLocator, String childLocator, String textItem) throws InterruptedException {
        //Hanh vi de thao tac len dropdown
        //1-Cho cho dropdown co the thao tac len duoc (clickable)
        //2-Click vao element nao de no xo ra cai dropdown
        driver.findElement(By.xpath(parentLocator)).click();
        sleepInSecond(2);

        //2-Click vao element nao de no xo ra cai dropdown
        //driver.findElement(By.cssSelector(parentCss)).click();
//        Thread.sleep(2000); //2s

        //3-CHo cho tat ca cac item duoc load ra
        //4-Tim item nao dung voi mong doi
        List<WebElement> allitems = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childLocator)));

        //4-Tim item nao dung voi mong doi

        //List<WebElement> allitems = driver.findElements(By.cssSelector(childCss));
        //5-CLick vao item do
        for(WebElement item:allitems){
            if(item.getText().equals(textItem)){
                item.click();
                break;
            }
        }
    }
    public void sleepInSecond(long timeInSeconds) throws InterruptedException {
        Thread.sleep(timeInSeconds*1000);
    }
    public String getElementAttribute(WebDriver driver, String locator, String attributeName ) {
        return getElement(driver,locator).getAttribute(attributeName);
    }
    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver,locator).getText();
    }
    public String getCssValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver,locator).getCssValue(propertyName);
    }
    public String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }
    public int getListElementNumber(WebDriver driver, String locator, String propertyName) {
        return getListElement(driver, locator).size();
    }
    public void checkToCheckboxRadio(WebDriver driver, String locator) {
        if (!getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }
    public void uncheckToCheckbox(WebDriver driver, String locator) {
        if (getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }
    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }
    public boolean isElementEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }
    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }
    public void switchToIframe(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }
    public void switchToDefaultPage(WebDriver driver) {
        driver.switchTo().defaultContent();
    }
    public void clickToElementByAction(WebDriver driver, String locator) {
        new Actions(driver).click(getElement(driver,locator)).perform();
    }

    public void clickAndHoldToElement(WebDriver driver, String locator) {
        new Actions(driver).clickAndHold(getElement(driver,locator)).perform();
    }
    public void releaseLeftMouse(WebDriver driver) {
        new Actions(driver).release();
    }
    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getElement(driver,locator)).perform();
    }
    public void rightClickToElement(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getElement(driver,locator)).perform();
    }
    public void drapAndDropElement(WebDriver driver, String sourceLocator,String targetLocator) {
        new Actions(driver).dragAndDrop(getElement(driver,sourceLocator), getElement(driver, targetLocator)).perform();
    }
    public void pressKeyToElement(WebDriver driver, String locator, Keys keys) {
        new Actions(driver).sendKeys(getElement(driver,locator), keys).perform();
    }
    public void scrollToElement(WebDriver driver, String locator) {
        new Actions(driver).scrollToElement(getElement(driver, locator)).perform();
    }
    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void sleepInSecond(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hightlightElement(WebDriver driver,String locator) {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getElement(driver,locator));
        sleepInSecond(3);
    }

    public String getElementTextByJS(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].textContent;", getElement(driver,locator));
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver,locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver,locator));
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(driver,locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver,locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver,locator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver,locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].validationMessage;", getElement(driver,locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor)driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(driver,locator));
    }
    public void waitForELementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }
    public void waitForELementSelected(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeSelected(getByXpath(locator)));
    }
    public void waitForELementPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
    }
    public void waitForELementInVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
    }
    public void waitForELementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }
}
