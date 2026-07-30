package pageUIs.jQuery;

public class HomePageUI {
    public static final String DYNAMIC_PAGE_NUMBER_LOCATOR = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
    public static final String DYNAMIC_PAGE_ACTIVED_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s'and @class='qgrd-pagination-page-link active']";
    public static final String DYNAMIC_HEADER_TEXTBOX_BY_NAME="xpath=//div[text()='%s']/parent::div/following-sibling::input";
    public static final String DYNAMIC_PAGE_INFO="xpath=//td[@data-key='females'and text()='%s']/following-sibling::td[@data-key='country'and text()='%s']/following-sibling::td[@data-key='males'and text()='%s']/following-sibling::td[@data-key='total'and text()='%s']";
    public static final String DYNAMIC_ACTION_BY_COUNTRY_NAME="Xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class, '%s')]";


    public static final String LOAD_DATA_BUTTON = "css=button#load";
    public static final String DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME = "Xpath=//th[text()='%s']/preceding-sibling::th";
    public static final String DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]/input";
    public static final String DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//select";
    public static final String DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//input";

}
