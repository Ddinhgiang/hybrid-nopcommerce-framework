package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import pageObjects.*;
//import pageUIs.*;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Set;

public class BasePage {

    // Tuan theo nguyen tac cua tinh dong goi
    //Ham khoi tao de map driver
    //Bien STatic co the truy cap  truc tiep tu pham vi Class

    public static BasePage getBasePage() {
        return new BasePage();
    }

    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert(WebDriver driver) {
        waitAlertPresence(driver).accept();
    }

    public void cancelToAlert(WebDriver driver) {
        waitAlertPresence(driver).dismiss();
    }

    public String getAlertText(WebDriver driver) {
        return waitAlertPresence(driver).getText();
    }

    public void sendKeyToAlert(WebDriver driver, String keysToSend) {
        waitAlertPresence(driver).sendKeys(keysToSend);
    }
    private void switchToWindowByTitle(WebDriver driver, String expectedPageTitle) throws InterruptedException {
        // Lấy hết toàn bộ ID của window/tab
        Set <String> allWindowIds = driver.getWindowHandles();

        //Dùng vòng lặp duyệt qua từng Id
        for (String id:allWindowIds) {
            //Mỗi lần duyệt sẽ cho nó switch vào trước
            driver.switchTo().window(id);
            Thread.sleep(2000);
            String pageTitle = driver.getTitle();
            //Kiem tra title
            if (pageTitle.equals(expectedPageTitle)) {
                break;
            }
        }
    }

    //Chỉ đúng với 2 window/tan
    private void switchToWindowById(WebDriver driver, String windowId) {
        //Lấy ra hết tất cả các ID của window/tab hiện tại
        Set<String> allWindowIDs = driver.getWindowHandles();
        //Dùng vòng lặp duyệt qua từng iD một
        for(String id: allWindowIDs) {
            //Dùng vòng lặp để duyệt qua từng ID một
            if(!id.equals(windowId)) {
                driver.switchTo().window(id);
            }
        }
    }
    private void closeAllWindowWithoutParent(WebDriver driver, String githubWindowId) throws InterruptedException {
        Set <String> allWindowIds = driver.getWindowHandles();
        for (String id:allWindowIds) {
            if(!id.equals(githubWindowId)) {
                driver.switchTo().window(id);
                Thread.sleep(2000);
                driver.close();
            }
        }

    }
    protected WebElement getElement(WebDriver driver, String locator) {
        /* return driver.findElement(By.xpath(locator));*/
        return driver.findElement(getByLocator(locator));
    }
    protected List<WebElement> getListElement(WebDriver driver, String locator) {
//        return driver.findElements(By.xpath(locator));
        return driver.findElements(getByLocator(locator));
    }
    private String castParameter(String locator, String... restParameter) {
        return String.format(locator, (Object[]) restParameter);
    }
    private By getByLocator(String prefixLocator) {
        By by = null;
        if (prefixLocator.toUpperCase().startsWith("ID")) {
            by = By.id(prefixLocator.substring(3));
        } else  if (prefixLocator.toUpperCase().startsWith("CLASS")) {
            by = By.className(prefixLocator.substring(6));
        } else  if (prefixLocator.toUpperCase().startsWith("NAME")) {
            by = By.name(prefixLocator.substring(5));
        } else  if (prefixLocator.toUpperCase().startsWith("TAGNAME")) {
            by = By.tagName(prefixLocator.substring(8));
        } else if(prefixLocator.toUpperCase().startsWith("CSS")) {
            by = By.cssSelector(prefixLocator.substring(4));
        } else  if (prefixLocator.toUpperCase().startsWith("XPATH")) {
            by = By.xpath(prefixLocator.substring(6));
        } else {
            throw new RuntimeException("Locator type is not support!!!");
        }
        return by;
    }
    private By getByXpath(String locator) {
        return By.xpath(locator);
    }


    public void clickToELement(WebDriver driver, String locator) {
//        driver.findElement(By.xpath(locator)).click();
        getElement(driver, locator).click();
    }
    public void clickToELement(WebDriver driver, String locator, String restParameter) {
//        driver.findElement(By.xpath(locator)).click();
        getElement(driver, castParameter(locator, restParameter)).click();
    }
    public void sendKeyToElement(WebDriver driver, String locator, CharSequence keyToSend) {
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(keyToSend);
    }
    //DA TU SUA CHO NAY< CAN DE Y
    public void sendKeyToElement(WebDriver driver, String locator, CharSequence keyToSend, String restParameter) {
        //getElement(driver, castParameter(locator, restParameter)).clear();
        getElement(driver, castParameter(locator, restParameter)).sendKeys(keyToSend);
    }
    public void selectItemInDropdown(WebDriver driver, String locator, String textItem) {
        new Select(  getElement(driver, locator)).selectByVisibleText(textItem);
    }
    public void selectItemInDropdown(WebDriver driver, String locator, String textItem, String restParameter) {
        new Select(  getElement(driver, castParameter(locator, restParameter))).selectByVisibleText(textItem);
    }
    public String getSelectedItemInDropdown(WebDriver driver, String locator) {
        return new Select(driver.findElement(By.xpath(locator))).getFirstSelectedOption().getText();
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
        List<WebElement> allitems = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childLocator)));

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
    public String getElementAttribute(WebDriver driver, String locator, String attributeName, String restParameter ) {
        return getElement(driver,castParameter(locator, restParameter)).getAttribute(attributeName);
    }
    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver,locator).getText();
    }
    public String getElementText(WebDriver driver, String locator, String restParameter) {
        return getElement(driver,castParameter(locator, restParameter)).getText();
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
    public boolean isElementDisplayed(WebDriver driver, String locator, String ...restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).isDisplayed();
    }
    public boolean isElementEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }
    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }
    public boolean isElementSelected(WebDriver driver, String locator, String restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).isSelected();
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
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }
    public void waitForELementVisible(WebDriver driver, String locator, String ...restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castParameter(locator, restParameter))));
    }
    public void waitForELementSelected(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }
    public void waitForELementSelected(WebDriver driver, String locator, String restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(castParameter(locator, restParameter))));
    }
    public void waitForELementPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }
    public void waitForELementInVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }
    public void waitForELementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }
    public void waitForELementClickable(WebDriver driver, String locator, String restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(castParameter(locator, restParameter))));
    }

}