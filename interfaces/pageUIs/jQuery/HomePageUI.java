package pageUIs.jQuery;

public class HomePageUI {
    public static final String DYNAMIC_PAGE_NUMBER_LOCATOR = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
    public static final String DYNAMIC_PAGE_ACTIVED_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s'and @class='qgrd-pagination-page-link active']";
    public static final String DYNAMIC_HEADER_TEXTBOX_BY_NAME="xpath=//div[text()='%s']/parent::div/following-sibling::input";
    public static final String DYNAMIC_PAGE_INFO="xpath=//td[@data-key='females'and text()='%s']/following-sibling::td[@data-key='country'and text()='%s']/following-sibling::td[@data-key='males'and text()='%s']/following-sibling::td[@data-key='total'and text()='%s']";
}
